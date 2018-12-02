package com.gauravbytes.springjdbc;

import java.util.logging.Logger;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;

import com.gauravbytes.springjdbc.ds.JdbcDataSourceUtils;

/**
 * Example for {@link PreparedStatementSetter}
 * 
 * @author Gaurav Rai Mazra <a href="https://gauravbytes.com">My blog</a>
 *         <a href="https://lineofcode.in">Website</a>
 */
public class PreparedStatementSetterExample {
	private static final Logger log = Logger.getGlobal();

	public static void main(String[] args) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(JdbcDataSourceUtils.getH2Database());
		jdbcTemplate.afterPropertiesSet();
		
		int updateCount = jdbcTemplate.update("insert into product(name, description) values(?,?)", ps -> {
			ps.setString(1, "Lenovo Bag");
			ps.setString(2, "Handcrafted bags by Lenovo");
		});
		
		log.info(() -> String.format("Product inserted: %d", updateCount));
	}
}
