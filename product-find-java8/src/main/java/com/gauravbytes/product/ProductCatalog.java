package com.gauravbytes.product;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
	
/**
 * 
 * @author Gaurav Rai Mazra
 *
 */
public class ProductCatalog {
	private List<Product> products = new ArrayList<>();

	public void add(Product product) {
		products.add(product);
	}
	
	private Stream<Product> getProductStream() {
		return StreamSupport.stream(this.products.spliterator(), false);
	}

	public Stream<Product> stream() {
		return products.stream();
	}
}
