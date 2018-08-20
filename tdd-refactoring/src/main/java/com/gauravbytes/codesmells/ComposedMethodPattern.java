package com.gauravbytes.codesmells;

import java.util.Arrays;

/**
 * 
 * @author Gaurav Rai Mazra 
 * https://www.gauravbytes.com
 * https://www.lineofcode.in
 */
public class ComposedMethodPattern {
	static class ArrayList {
		private String[] elements = new String[10];
		private int index;

		public boolean add(String ele) {
			int newSize = index + 1;
			int capacity = elements.length;
			if (newSize - capacity <= 0) {
				elements = Arrays.copyOf(elements, capacity + 10);
			}
			elements[index++] = ele;
			return true;
		}

	}

	static class ComposedMethodArrayList {
		private String[] elements = new String[10];
		private int index;

		public boolean add(String ele) {
			if (isCapacityFull())
				grow();

			addElement(ele);
			return true;
		}
		
		private boolean isCapacityFull() {
			int newSize = index + 1;
			int capacity = elements.length;
			return newSize - capacity <= 0;
		}

		private void grow() {
			int capacity = elements.length;
			elements = Arrays.copyOf(elements, capacity + 10);
		}

		private void addElement(String ele) {
			elements[index++] = ele;
		}
	}
}
