package com.gauravbytes.algorithms.search;

/**
 * 
 * @author Gaurav Rai Mazra
 * {@linkplain https://grai.dev}
 *
 */
public class LinearSearch {
	public int search(final int[] arr, final int elementToSearch) {
		for (int i = 0; i < arr.length; i++) {
			if (elementToSearch == arr[i])
				return i;
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] arr = {1, 20, 10, 1};
		int elementToSearch = 10;
		System.out.println("Element found at index: " + new LinearSearch().search(arr, elementToSearch));
	}
}
