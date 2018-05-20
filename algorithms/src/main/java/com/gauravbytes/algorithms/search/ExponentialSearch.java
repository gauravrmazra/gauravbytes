package com.gauravbytes.algorithms.search;

/**
 * 
 * @author Gaurav Rai Mazra
 *	{@linkplain https://lineofcode.in}
 *  {@linkplain https://gauravbytes.com}
 */
public class ExponentialSearch implements Search {
	private BinarySearch binarySearch = new NonRecursiveBinarySearch();
	
	
	@Override
	public int search(int[] arr, int elementToSearch) {
		if (elementToSearch == arr[0]) return 0;
		int i = 1;
		int n = arr.length;
		while (i < n && arr[i] <= elementToSearch) i *= 2;
		
		return binarySearch.binarySearch(arr, i / 2, Math.min(i, n), elementToSearch);
	}

}
