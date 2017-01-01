package com.gauravbytes.singleton.lazy;

import java.util.Objects;

/**
 * @author Mazra, Gaurav Rai
 *
 */
public class LazySingletonDCL {
	private static LazySingletonDCL INSTANCE;
	private static final Object MUTEX = new Object();
	
	private LazySingletonDCL() {
		
	}
	
	//Double check locking
	public static LazySingletonDCL getInstance() {
		LazySingletonDCL instance = INSTANCE;
		if (Objects.isNull(instance)) {
			synchronized (MUTEX) {
				if (Objects.isNull(instance))
					INSTANCE = instance = new LazySingletonDCL();
			}
		}
		return instance;
	}
}
