package com.gauravbytes.product;

/**
 * 
 * @author Gaurav Rai Mazra
 *
 */
public class Product {
	private String id;
	private String name;
	private Color color;
	private double price;
	private Size size;
	
	public Product(String id, String name, Color color, double price, Size size) {
		this.id = id;
		this.name = name;
		this.color = color;
		this.price = price;
		this.size = size;
	}
	
	public String getID() {
		return id;
	}
	
	public Color getColor() {
		return color;
	}

	public double getPrice() {
		return price;
	}

	public Size getSize() {
		return size;
	}

	public String getName() {
		return this.name;
	}
}
