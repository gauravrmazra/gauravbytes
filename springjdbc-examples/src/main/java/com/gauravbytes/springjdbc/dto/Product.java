package com.gauravbytes.springjdbc.dto;

/**
 *
 * @author Gaurav Rai Mazra
 * <a href="https://gauravbytes.com">My blog</a>
 * <a href="https://lineofcode.in">Website</a>
 */
public class Product {
	private int id;
	private String name;
	private String category;
	private String description;
	
	public Product() {
		// Default constructor
	}
	
	public Product(String name, String category, String description) {
		this.name = name;
		this.category = category;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", description=" + description + "]";
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
}
