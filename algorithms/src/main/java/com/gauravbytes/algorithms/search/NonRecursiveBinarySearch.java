package com.gauravbytes.algorithms.search;

/**
 * 
 * @author Gaurav Rai Mazra
 *	{@linkplain https://lineofcode.in}
 *  {@linkplain https://gauravbytes.com}
 */
public class NonRecursiveBinarySearch extends BinarySearch {
	@Override
	int binarySearch(int[] arr, int lo, int hi, int elementToSearch) {
		while (lo < hi && elementToSearch >= arr[lo] && elementToSearch <= arr[hi]) {
			int pos = pos(arr, lo, hi, elementToSearch);
			
			if (elementToSearch == arr[pos]) return pos;
			
			else if (arr[pos] < elementToSearch) lo = pos + 1;
			
			else hi = pos - 1;
		}
		return -1;
	}
}
