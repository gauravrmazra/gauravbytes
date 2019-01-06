package com.gauravbytes.springjdbc.dto;

import java.util.List;
import java.util.Objects;

public class ProductResponse {
	private boolean successful;
	private List<Product> products;
	
	private ProductResponse(boolean successful, List<Product> products)
	{
		this.successful = successful;
		this.products = products;
	}

	public boolean isSuccessful() {
		return successful;
	}

	public List<Product> getProducts() {
		return products;
	}
	
	public static ProductResponse of (List<Product> products) {
		boolean successful = Objects.nonNull(products) && !products.isEmpty();
		
		return new ProductResponse(successful, products);
	}

	@Override
	public String toString() {
		return "ProductResponse [successful=" + successful + ", products=" + products + "]";
	}
}
