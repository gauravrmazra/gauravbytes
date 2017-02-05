package com.gauravbytes.product;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * 
 * @author Gaurav Rai Mazra
 *
 */
public class ProductSearcher {
	private ProductCatalog catalog;

	public ProductSearcher(ProductCatalog catalog) {
		this.catalog = catalog;
	}

	public List<Product> selectBy(Predicate<Product> spec) {
		return catalog.stream().filter(spec).collect(Collectors.toList());
	}
}
