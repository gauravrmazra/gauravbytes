package com.gauravbytes.algorithms.search;

/**
 * 
 * @author Gaurav Rai Mazra
 * {@linkplain https://lineofcode.in}
 *
 */
public class BinarySearch {
	public int search(final int[] arr, final int elementToSearch) {
		return binarySearch(arr, 0, arr.length - 1, elementToSearch);
	}
	
	private int binarySearch(final int[] arr, final int start, final int last, final int elementToSearch) {
		if (last > start) {
			int mid = start + (last - start) / 2;
			
			if(elementToSearch == arr[mid])
				return mid;
			else if (elementToSearch < arr[mid])
				return binarySearch(arr, start, mid - 1, elementToSearch);
			else 
				return binarySearch(arr, mid + 1, last, elementToSearch);
		}
		
		
		return -1;
	}
}
