package com.gauravbytes.springjdbc;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;

import com.gauravbytes.springjdbc.dto.Product;

/**
 * 
 * @author Gaurav Rai Mazra <a href="https://gauravbytes.com">My blog</a>
 *         <a href="https://lineofcode.in">Website</a>
 */
public class ProductBatchPreparedStatementSetter implements BatchPreparedStatementSetter {

	private final List<Product> products;

	public ProductBatchPreparedStatementSetter(List<Product> products) {
		Objects.requireNonNull(products);
		this.products = products;
	}

	@Override
	public void setValues(PreparedStatement ps, int i) throws SQLException {
		Product product = products.get(i);
		ps.setString(1, product.getName());
		ps.setString(2, product.getDescription());
	}

	@Override
	public int getBatchSize() {
		return products.size();
	}

}
