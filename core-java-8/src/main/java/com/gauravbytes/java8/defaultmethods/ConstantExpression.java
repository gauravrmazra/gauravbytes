package com.gauravbytes.java8.defaultmethods;

public class ConstantExpression implements Expression {
	private double value;

	public ConstantExpression(double value) {
		this.value = value;
	}

	@Override
	public double evaluate() {
		return value;
	}

}
