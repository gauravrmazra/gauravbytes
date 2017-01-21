package com.gauravbytes.java8.defaultmethods;

/**
 * 
 * @author Gaurav Rai Mazra
 *
 */
public interface Expression {
	double evaluate();

	/**
	 * return the signum of result by evaluating expression
	 * 
	 * @return signum 0.0, 1.0, -1.0 based on Math.signum
	 */
	default double signum() {
		return signum(evaluate());
	}

	/**
	 * return the signum of the passed value
	 * 
	 * @param value
	 * @return signum 0.0, 1.0, -1.0 based on Math.signum
	 */
	static double signum(double value) {
		return Math.signum(value);
	}
}
