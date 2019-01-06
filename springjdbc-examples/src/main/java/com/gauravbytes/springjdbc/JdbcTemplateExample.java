package com.gauravbytes.springjdbc;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.jdbc.core.JdbcTemplate;

import com.gauravbytes.springjdbc.ds.JdbcDataSourceUtils;

/**
 * Examples of basic querying in JdbcTemplate
 * @author Gaurav Rai Mazra
 * <a href="https://gauravbytes.com">My blog</a>
 * <a href="https://lineofcode.in">Website</a>
 */
public class JdbcTemplateExample {
	private static final Logger log = Logger.getGlobal();
	
	public static void main(String[] args) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(JdbcDataSourceUtils.getH2Database());
		jdbcTemplate.afterPropertiesSet();
		Integer count = jdbcTemplate.queryForObject("select count(*) from product", Integer.class);
		log.info(() -> String.format("There are total %d products", count));
		
		Integer mobileProducts = jdbcTemplate.queryForObject("select count(*) from product where category=?", Integer.class, "mobile");
		log.info(() -> String.format("There are total %d mobile products", mobileProducts));
		
		List<String> mobileNames = jdbcTemplate.queryForList("select name from product where category='mobile'", String.class);
		log.info(() -> String.format("Name of mobiles: %s", mobileNames.toString()));
	}
}
