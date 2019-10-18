package com.gauravbytes.algorithms.search;

/**
 * 
 * @author Gaurav Rai Mazra {@linkplain https://grai.dev}
 *         {@linkplain https://gauravbytes.com}
 */
public class NonRecursiveBinarySearch extends BinarySearch {
	@Override
	int binarySearch(int[] arr, int lo, int hi, int elementToSearch,
			PositionDetectionStrategy positionDetectionStrategy) {
		while (lo <= hi && elementToSearch >= arr[lo] && elementToSearch <= arr[hi]) {
			int pos = positionDetectionStrategy.pos(lo, hi);

			if (elementToSearch == arr[pos])
				return pos;

			else if (arr[pos] < elementToSearch)
				lo = pos + 1;

			else
				hi = pos - 1;
		}
		return -1;
	}
}
