package com.gauravbytes.igniteexamples;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 
 * @author Gaurav Rai Mazra {@link https://lineofcode.in}
 *
 */
public class IgniteSqlExample {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("org.apache.ignite.IgniteJdbcThinDriver");

		createTables();

		insertDataInTables();
		
		selectDataFromTables();

	}

	public static void createTables() throws SQLException {
		try (Connection conn = DriverManager.getConnection("jdbc:ignite:thin://127.0.0.1/");
				Statement stmt = conn.createStatement();) {
			stmt.executeUpdate(
					"CREATE TABLE City (" + " id LONG PRIMARY KEY, name VARCHAR) " + " WITH \"template=replicated\"");

			stmt.executeUpdate("CREATE TABLE Person (" + " id LONG, name VARCHAR, city_id LONG, "
					+ " PRIMARY KEY (id, city_id)) " + " WITH \"backups=1, affinityKey=city_id\"");

			stmt.executeUpdate("CREATE INDEX idx_city_name ON City (name)");

			stmt.executeUpdate("CREATE INDEX idx_person_name ON Person (name)");
		}
	}

	public static void insertDataInTables() throws SQLException {
		try (Connection conn = DriverManager.getConnection("jdbc:ignite:thin://127.0.0.1/")) {
			insertInCityTable(conn);
			insertIntoPersonTable(conn);
		}
	}

	private static void insertIntoPersonTable(Connection conn) throws SQLException {
		try (PreparedStatement stmt = conn
				.prepareStatement("INSERT INTO Person (id, name, city_id) VALUES (?, ?, ?)")) {

			stmt.setLong(1, 1L);
			stmt.setString(2, "John Doe");
			stmt.setLong(3, 3L);
			stmt.executeUpdate();

			stmt.setLong(1, 2L);
			stmt.setString(2, "Jane Roe");
			stmt.setLong(3, 2L);
			stmt.executeUpdate();

			stmt.setLong(1, 3L);
			stmt.setString(2, "Mary Major");
			stmt.setLong(3, 1L);
			stmt.executeUpdate();

			stmt.setLong(1, 4L);
			stmt.setString(2, "Richard Miles");
			stmt.setLong(3, 2L);
			stmt.executeUpdate();
		}
	}

	private static void insertInCityTable(Connection conn) throws SQLException {
		try (PreparedStatement stmt = conn.prepareStatement("INSERT INTO City (id, name) VALUES (?, ?)")) {

			stmt.setLong(1, 1L);
			stmt.setString(2, "Forest Hill");
			stmt.executeUpdate();

			stmt.setLong(1, 2L);
			stmt.setString(2, "Denver");
			stmt.executeUpdate();

			stmt.setLong(1, 3L);
			stmt.setString(2, "St. Petersburg");
			stmt.executeUpdate();
		}
	}

	private static void selectDataFromTables() throws SQLException {
		try (Connection conn = DriverManager.getConnection("jdbc:ignite:thin://127.0.0.1/");
				Statement stmt = conn.createStatement()) {
			try (ResultSet rs = stmt
					.executeQuery("SELECT p.name, c.name " + " FROM Person p, City c " + " WHERE p.city_id = c.id")) {

				while (rs.next())
					System.out.println(rs.getString(1) + ", " + rs.getString(2));
			}
		}
	}
}
