package com.gauravbytes.singleton.eager;

/**
 * Eager initialized Singleton
 * @author Mazra, Gaurav Rai
 *
 */
public final class Singleton {
	private static final Singleton INSTANCE = new Singleton();
	
	private Singleton() {
		
	}
	
	public static Singleton getInstance() {
		return INSTANCE;
	}
	
}
