package com.gauravbytes.gkart.entity;

/**
 * 
 * @author Gaurav Rai Mazra
 *
 */
public enum Size {
	SMALL(0), MEDIUM(1), LARGE(2), NOT_APPLICABLE(3);
	private int size;

	Size(int size) {
		this.size = size;
	}

	public int getSize() {
		return this.size;
	}

	public static Size of(int size) {
		for (Size s : Size.values()) {
			if (s.getSize() == size)
				return s;
		}
		return Size.NOT_APPLICABLE;
	}
}
