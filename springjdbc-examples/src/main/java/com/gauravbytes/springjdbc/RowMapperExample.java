package com.gauravbytes.springjdbc;

import java.util.logging.Logger;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.gauravbytes.springjdbc.ds.JdbcDataSourceUtils;
import com.gauravbytes.springjdbc.dto.Product;

/**
 * Examples of {@link RowMapper}, {@link ProductRowMapper} usage in JdbcTemplate
 * @author Gaurav Rai Mazra
 * <a href="https://gauravbytes.com">My blog</a>
 * <a href="https://lineofcode.in">Website</a>
 */
public class RowMapperExample {
	private static final Logger log = Logger.getGlobal();
	
	public static void main(String[] args) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(JdbcDataSourceUtils.getH2Database());
		Product apple = jdbcTemplate.queryForObject("select * from product where id=1", new ProductRowMapper());
		log.info(apple::toString);
	}
}
