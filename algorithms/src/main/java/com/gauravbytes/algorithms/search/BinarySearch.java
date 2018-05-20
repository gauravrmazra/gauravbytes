package com.gauravbytes.algorithms.search;

/**
 * 
 * @author Gaurav Rai Mazra
 *	{@linkplain https://lineofcode.in}
 *  {@linkplain https://gauravbytes.com}
 */
public class BinarySearch implements Search {
	
	@Override
	public int search(final int[] arr, final int elementToSearch) {
		return binarySearch(arr, 0, arr.length - 1, elementToSearch);
	}
	
	protected int pos(int[] arr, int lo, int hi, int elementToSearch) {
		return lo + (hi - lo) / 2;
	}
	
	int binarySearch(final int[] arr, final int lo, final int hi, final int elementToSearch) {
		if (hi > lo) {
			int mid = pos(arr, lo, hi, elementToSearch);
			
			if(elementToSearch == arr[mid])
				return mid;
			else if (elementToSearch < arr[mid])
				return binarySearch(arr, lo, mid - 1, elementToSearch);
			else 
				return binarySearch(arr, mid + 1, hi, elementToSearch);
		}
		
		
		return -1;
	}
}
