package com.gauravbytes.springjdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.gauravbytes.springjdbc.ds.JdbcDataSourceUtils;
import com.gauravbytes.springjdbc.dto.Product;

/**
 * Examples for Spring Jdbctemplate
 * @author Gaurav Rai Mazra
 * <a href="https://gauravbytes.com">My blog</a>
 * <a href="https://lineofcode.in">Website</a>
 */
public class JdbcTemplateExample {
	static class ProductRowMapper implements RowMapper<Product> {

		@Override
		public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
			Product product = new Product();
			product.setId(rs.getInt("id"));
			product.setName(rs.getString("name"));
			product.setDescription(rs.getString("description"));
			return product;
		}
		
	}
	
	public static void main(String[] args) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(JdbcDataSourceUtils.getH2Database());
		jdbcTemplate.afterPropertiesSet();
		Product apple = jdbcTemplate.queryForObject("select * from product where id=1", new ProductRowMapper());
		System.out.println(apple);
	}
}
