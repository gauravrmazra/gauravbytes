package com.gauravbytes.serialization;

import java.io.Serializable;

/**
 * 
 * @author Gaurav Rai Mazra <a href="http://www.gauravbytes.com">Catch me</a>
 *
 */
public class Dog implements Serializable {
	private static final long serialVersionUID = 8661314562327474362L;

	private int height;
	private String name;
	
	public Dog(int height, String name) {
		super();
		this.height = height;
		this.name = name;
	}

	public int getHeight() {
		return height;
	}
	
	public void setHeight(int height) {
		this.height = height;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Dog [height=" + height + ", name=" + name + "]";
	}
}
