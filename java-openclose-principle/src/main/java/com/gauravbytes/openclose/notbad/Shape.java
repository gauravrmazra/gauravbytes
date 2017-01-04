package com.gauravbytes.openclose.notbad;

/**
 * 
 * @author Gaurav Rai Mazra
 *
 */
public abstract class Shape {
	private ShapeType type;
	
	public Shape(ShapeType type) {
		this.type = type;
	}
	
	public ShapeType getType() {
		return this.type;
	}
	
	public abstract void draw();
}
