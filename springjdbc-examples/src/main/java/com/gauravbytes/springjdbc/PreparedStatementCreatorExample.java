package com.gauravbytes.springjdbc;

import java.util.logging.Logger;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;

import com.gauravbytes.springjdbc.ds.JdbcDataSourceUtils;

/**
 * Example usage of {@link PreparedStatementCreator} and
 * {@link ReturnGeneratedKeysPreparedStatementCreator}
 * 
 * @author Gaurav Rai Mazra <a href="https://gauravbytes.com">My blog</a>
 *         <a href="https://lineofcode.in">Website</a>
 */
public class PreparedStatementCreatorExample {
	private static final Logger log = Logger.getGlobal();

	public static void main(String[] args) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(JdbcDataSourceUtils.getH2Database());
		jdbcTemplate.afterPropertiesSet();
		Integer key = jdbcTemplate.execute(
				new ReturnGeneratedKeysPreparedStatementCreator(
						"insert into product(name, description) values('Acer Laptop', 'Predator series')"),
				new GeneratedKeysPreparedStatementCallback());
		log.info(() -> String.format("Product saved in database with key: %d", key));
	}
}
