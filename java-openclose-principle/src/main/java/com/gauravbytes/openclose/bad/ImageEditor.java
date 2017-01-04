package com.gauravbytes.openclose.bad;

/**
 * 
 * @author Gaurav Rai Mazra
 *
 */
public class ImageEditor {
	public void drawShape(Shape shape) {
		if (shape.getType() == ShapeType.RECTANGLE) {
			drawRectangle(shape);
		}
		else if (shape.getType() == ShapeType.SQUARE) {
			drawSquare(shape);
		}
	}

	private void drawSquare(Shape shape) {
		// logic to draw square
	}

	private void drawRectangle(Shape shape) {
		// LOGIC to draw triangle
	}
}
