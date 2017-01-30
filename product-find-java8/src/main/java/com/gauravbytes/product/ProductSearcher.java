package com.gauravbytes.product;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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

	public List<Product> byID(String pid) {
		List<Product> foundProducts = new ArrayList<Product>();
		Iterator<Product> products = catalog.iterator();
		Product product;
		while (products.hasNext()) {
			product = products.next();
			if (product.getID().equals(pid))
				foundProducts.add(product);
		}
		return foundProducts;
	}

	public List<Product> byColor(Color productColorToMatch) {
		List<Product> foundProducts = new ArrayList<Product>();
		Iterator<Product> products = catalog.iterator();
		Product product;
		while (products.hasNext()) {
			product = products.next();
			if (product.getColor().equals(productColorToMatch))
				foundProducts.add(product);
		}
		return foundProducts;
	}

	public List<Product> byPrice(double productPriceLimit) {
		List<Product> foundProducts = new ArrayList<Product>();
		Iterator<Product> products = catalog.iterator();
		Product product;
		while (products.hasNext()) {
			product = products.next();
			if (product.getPrice() == productPriceLimit) 
				foundProducts.add(product);
		}
		return foundProducts;
	}

	public List<Product> bySize(Size sizeToFind) {
		List<Product> foundProducts = new ArrayList<Product>();
		Iterator<Product> products = catalog.iterator();
		Product product;
		while (products.hasNext()) {
			product = products.next();
			if (product.getSize() == sizeToFind) 
				foundProducts.add(product);
		}
		return foundProducts;
	}

	public List<Product> belowPrice(double price) {
		List<Product> foundProducts = new ArrayList<Product>();
		Iterator<Product> products = catalog.iterator();
		Product product;
		while (products.hasNext()) {
			product = products.next();
			if (product.getPrice() < price) 
				foundProducts.add(product);
		}
		return foundProducts;
	}

	public List<Product> byColorAndBelowPrice(Color color, double price) {
		List<Product> foundProducts = new ArrayList<Product>();
		Iterator<Product> products = catalog.iterator();
		Product product;
		while (products.hasNext()) {
			product = products.next();
			if (product.getPrice() < price && product.getColor() == color) 
				foundProducts.add(product);
		}
		return foundProducts;
	}

	public List<Product> byColorSizeAndBelowPrice(Color color, Size size, double price) {
		List<Product> foundProducts = new ArrayList<Product>();
		Iterator<Product> products = catalog.iterator();
		Product product;
		while (products.hasNext()) {
			product = products.next();
			if (product.getColor() == color && 
				product.getSize() == size &&
				product.getPrice() < price)
				foundProducts.add(product);
		}
		return foundProducts;
	}

	public List<Product> byColorAndAbovePrice(Color color, double price) {
		List<Product> foundProducts = new ArrayList<Product>();
		Iterator<Product> products = catalog.iterator();
		Product product;
		while (products.hasNext()) {
			product = products.next();
			if (product.getColor() == color && 
				product.getPrice() > price)
				foundProducts.add(product);
		}
		return foundProducts;
	}

	public List<Product> belowPriceAndNotColor(double price, Color color) {
		List<Product> foundProducts = new ArrayList<Product>();
		Iterator<Product> products = catalog.iterator();
		Product product;
		while (products.hasNext()) {
			product = products.next();
			if (product.getPrice() < price && product.getColor() != color)
				foundProducts.add(product);
		}
		return foundProducts;
	}
}
