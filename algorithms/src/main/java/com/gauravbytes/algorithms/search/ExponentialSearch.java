package com.gauravbytes.algorithms.search;

import com.gauravbytes.algorithms.search.BinarySearch.PositionDetectionStrategy;

/**
 * 
 * @author Gaurav Rai Mazra {@linkplain https://grai.dev}
 *         {@linkplain https://gauravbytes.com}
 */
public class ExponentialSearch implements Search {
	private BinarySearch binarySearch = new NonRecursiveBinarySearch();

	@Override
	public int search(int[] arr, int elementToSearch) {
		if (elementToSearch == arr[0])
			return 0;
		int i = 1;
		int n = arr.length;
		while (i < n && arr[i] <= elementToSearch)
			i *= 2;

		PositionDetectionStrategy positionDetectionStrategy = (lo, hi) -> lo + (hi - lo) / 2;
		return binarySearch.binarySearch(arr, i / 2, Math.min(i, n), elementToSearch, positionDetectionStrategy);
	}

}
