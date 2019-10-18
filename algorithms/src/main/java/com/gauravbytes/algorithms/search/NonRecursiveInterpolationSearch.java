package com.gauravbytes.algorithms.search;

/**
 * 
 * @author Gaurav Rai Mazra {@linkplain https://grai.dev}
 *         {@linkplain https://gauravbytes.com}
 */
public class NonRecursiveInterpolationSearch extends NonRecursiveBinarySearch {

	@Override
	public int search(int[] arr, int elementToSearch) {
		PositionDetectionStrategy positionDetectionStrategy = (lo, hi) -> lo
				+ (((elementToSearch - arr[lo]) * (hi - lo)) / (arr[hi] - arr[lo]));
		return this.binarySearch(arr, 0, arr.length - 1, elementToSearch, positionDetectionStrategy);
	}
}
