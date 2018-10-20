package com.gauravbytes.springjdbc.ds;

import javax.sql.DataSource;

import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

/**
 * Config class for embedded datasource
 * @author Gaurav Rai Mazra
 * <a href="https://gauravbytes.com">My blog</a>
 * <a href="https://lineofcode.in">Website</a>
 */
public class JdbcDataSourceUtils {
	public static DataSource getH2Database()
	{
		return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2)
		.addScript("classpath:/create-db.sql")
		.addScript("classpath:/insert-data.sql")
		.build();
	}
}
