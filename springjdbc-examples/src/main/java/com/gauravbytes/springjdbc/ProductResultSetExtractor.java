package com.gauravbytes.springjdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import com.gauravbytes.springjdbc.dto.Product;

/**
 * Customized ResultSetExtractor used to return List of Products
 * @author Gaurav Rai
 * 
 * <a href="https://gauravbytes.com">My blog</a>
 * <a href="https://lineofcode.in">Website</a>
 */
public class ProductResultSetExtractor implements ResultSetExtractor<List<Product>> {
	private final RowMapper<Product> productRowMapper;
	
	public ProductResultSetExtractor(RowMapper<Product> productRowMapper) {
		super();
		this.productRowMapper = productRowMapper;
	}

	@Override
	public List<Product> extractData(ResultSet rs) throws SQLException {
		final List<Product> products = new ArrayList<>();

		int rowNum = 0;
		while(rs.next()) {
			products.add(productRowMapper.mapRow(rs, rowNum));
			rowNum++;
		}
		
		return products;
	}

}
