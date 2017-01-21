package com.gauravbytes.java8.lambda;

import java.util.concurrent.Callable;

/**
 * 
 * @author Gaurav Rai Mazra
 *
 */
public class LambdaTest {
	@FunctionalInterface
	interface Cup<T> {
		public T cup();
	}
	
	public static void main(String[] args) {
		LambdaTest lambda = new LambdaTest();
		// left side -> right side
		// left side is parameter/arguments/ or can be empty
		// right side is body of lambda
		
		lambda.invoke(() -> "Callable");
	}
	
	public void invoke(Runnable r) {
		r.run();
	}
	
	public <T> T invoke (Callable<T> c) {
		try {
			return c.call();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
