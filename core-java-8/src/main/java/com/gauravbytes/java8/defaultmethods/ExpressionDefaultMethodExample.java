package com.gauravbytes.java8.defaultmethods;

/**
 * 
 * @author Gaurav Rai Mazra
 *
 */
public class ExpressionDefaultMethodExample {
	public static void main(String[] args) {
		Expression expression = new ConstantExpression(32.0d);
		System.out.println(expression.signum());
	}
}
