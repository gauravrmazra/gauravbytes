package com.gauravbytes.gkart.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Formula;


/**
 * 
 * @author Gaurav Rai Mazra
 * <a href="http://www.gauravbytes.com">Catch me</a>
 */
@Entity
@Table(name = "products", schema = "product")
public class Product {
	@Id
	private String id;
	private String name;
	private Color color;
	private double price;
	private Size size;
	
	@Transient
	@Formula("SELECT AVG(rating) FROM product_ratings pr where pr.product_id=id")
	private double averageRating;
	
	public Product() {
		
	}
	
	public Product(String id, String name, Color color, double price, Size size) {
		super();
		this.id = id;
		this.name = name;
		this.color = color;
		this.price = price;
		this.size = size;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Size getSize() {
		return size;
	}

	public void setSize(Size size) {
		this.size = size;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((size == null) ? 0 : size.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (color != other.color)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		if (size != other.size)
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Product [id=").append(id).append(", name=").append(name).append(", color=").append(color)
				.append(", price=").append(price).append(", size=").append(size).append("]");
		return builder.toString();
	}
}
