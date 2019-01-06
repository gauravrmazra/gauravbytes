package com.gauravbytes.springjdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import com.gauravbytes.springjdbc.dto.Product;
import com.gauravbytes.springjdbc.dto.ProductResponse;

/**
 * Customized ResultSetExtractor used to return List of Products
 * @author Gaurav Rai Mazra
 * 
 * <a href="https://gauravbytes.com">My blog</a>
 * <a href="https://lineofcode.in">Website</a>
 */
public class ProductResultSetExtractor implements ResultSetExtractor<ProductResponse> {
	private final RowMapper<Product> productRowMapper;
	
	public ProductResultSetExtractor(RowMapper<Product> productRowMapper) {
		super();
		this.productRowMapper = productRowMapper;
	}

	@Override
	public ProductResponse extractData(ResultSet rs) throws SQLException {
		final List<Product> products = new ArrayList<>();

		int rowNum = 0;
		while(rs.next()) {
			products.add(productRowMapper.mapRow(rs, rowNum));
			rowNum++;
		}

		return ProductResponse.of(products);
	}

}
