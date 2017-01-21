package com.gauravbytes.java8.defaultmethods;

/**
 * 
 * @author Gaurav Rai Mazra
 *
 */
public abstract class BinaryExpression implements Expression {
	private Expression left;
	private Expression right;

	public BinaryExpression(Expression left, Expression right) {
		super();
		this.left = left;
		this.right = right;
	}

	Expression getLeft() {
		return this.left;
	}

	Expression getRight() {
		return this.right;
	}
}
