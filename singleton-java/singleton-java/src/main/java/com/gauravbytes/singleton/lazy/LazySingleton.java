package com.gauravbytes.singleton.lazy;

/**
 * 
 * @author Mazra, Gaurav Rai
 *
 */
public class LazySingleton {
	
	private static final class InstanceHolder {
		private static final LazySingleton INSTANCE = new LazySingleton();
	}

	private LazySingleton() {
		
	}
	
	// with instance holder class
	public static final LazySingleton getInstance() {
		return InstanceHolder.INSTANCE;
	}
}
