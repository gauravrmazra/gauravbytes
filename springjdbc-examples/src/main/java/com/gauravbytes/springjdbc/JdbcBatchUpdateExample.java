package com.gauravbytes.springjdbc;

import java.util.Arrays;
import java.util.logging.Logger;

import org.springframework.jdbc.core.JdbcTemplate;

import com.gauravbytes.springjdbc.ds.JdbcDataSourceUtils;
import com.gauravbytes.springjdbc.dto.Product;

/**
 * Examples of batch updates in JdbcTemplate
 * 
 * @author Gaurav Rai Mazra <a href="https://gauravbytes.com">My blog</a>
 *         <a href="https://lineofcode.in">Website</a>
 */
public class JdbcBatchUpdateExample {
	private static final Logger log = Logger.getGlobal();

	public static void main(String[] args) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(JdbcDataSourceUtils.getH2Database());
		jdbcTemplate.afterPropertiesSet();

		int[] results = jdbcTemplate.batchUpdate("insert into product (name, description) values(?,?)",
				new ProductBatchPreparedStatementSetter(
						Arrays.asList(new Product("Lenovo Laptop", "Thinkpad series laptop"),
								new Product("Acer Laptop", "Predator series laptop"))));
		log.info(() -> String.format("Inserted rows: %s", Arrays.toString(results)));
	}
}
