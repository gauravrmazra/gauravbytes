package com.gauravbytes.springjdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.SqlProvider;

/**
 * This class returns the generated keys by the database
 * 
 * @author Gaurav Rai Mazra <a href="https://gauravbytes.com">My blog</a>
 *         <a href="https://lineofcode.in">Website</a>
 */
public class ReturnGeneratedKeysPreparedStatementCreator implements PreparedStatementCreator, SqlProvider {
	private final String sql;
	private String[] generatedColumnNames;

	public ReturnGeneratedKeysPreparedStatementCreator(String sql) {
		this(sql, Collections.emptyList());
	}

	public ReturnGeneratedKeysPreparedStatementCreator(String sql, List<String> generatedColumnNames) {
		this.sql = sql;
		this.generatedColumnNames = Objects.nonNull(generatedColumnNames)
				? generatedColumnNames.toArray(new String[generatedColumnNames.size()])
				: new String[0];
	}

	@Override
	public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
		return generatedColumnNames.length > 0 ? con.prepareStatement(this.sql, this.generatedColumnNames)
				: con.prepareStatement(this.sql, Statement.RETURN_GENERATED_KEYS);
	}

	@Override
	public String getSql() {
		return this.sql;
	}

}
