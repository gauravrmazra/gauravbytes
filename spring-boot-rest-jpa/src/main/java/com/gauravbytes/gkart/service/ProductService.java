package com.gauravbytes.gkart.service;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.gauravbytes.gkart.entity.Product;
import com.gauravbytes.gkart.jpa.ProductRepository;

/**
 * 
 * @author Gaurav Rai Mazra
 * <a href="http://www.gauravbytes.com">Catch me</a>
 */
@Service
public class ProductService implements GenericService<Product, String> {
	private final ProductRepository productRepository;
	
	public ProductService(final ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@Override
	public String getId(Product entity) {
		return entity.getId();
	}

	@Override
	public CrudRepository<Product, String> getRepository() {
		return this.productRepository;
	}

}
