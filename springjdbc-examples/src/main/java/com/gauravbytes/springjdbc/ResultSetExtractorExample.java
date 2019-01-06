package com.gauravbytes.springjdbc;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.jdbc.core.JdbcTemplate;

import com.gauravbytes.springjdbc.ds.JdbcDataSourceUtils;
import com.gauravbytes.springjdbc.dto.Product;

/**
 * Examples of querying complex object with resultset extractor
 * 
 * @author Gaurav Rai Mazra 
 * <a href="https://gauravbytes.com">My blog</a>
 * <a href="https://lineofcode.in">Website</a>
 */
public class ResultSetExtractorExample {
	private static final Logger log = Logger.getGlobal();

	public static void main(String[] args) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(JdbcDataSourceUtils.getH2Database());

		List<Product> products = jdbcTemplate.query("select * from product",
				new ProductResultSetExtractor(new ProductRowMapper()));

		log.info(() -> String.format("Total product retrieved are: %d", products.size()));
		log.info(products::toString);
	}
}
