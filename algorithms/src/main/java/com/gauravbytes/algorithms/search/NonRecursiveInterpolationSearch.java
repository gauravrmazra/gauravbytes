package com.gauravbytes.algorithms.search;

/**
 * 
 * @author Gaurav Rai Mazra
 *	{@linkplain https://lineofcode.in}
 *  {@linkplain https://gauravbytes.com}
 */
public class NonRecursiveInterpolationSearch extends NonRecursiveBinarySearch {
	@Override
	protected int pos(int[] arr, int lo, int hi, int elementToSearch) {
		return lo + (((elementToSearch - arr[lo]) * (hi - lo)) / (arr[hi] - arr[lo]));
	}
}
