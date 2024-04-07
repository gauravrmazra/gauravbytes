package cc.gaurav.algorithms.search;

import java.util.Arrays;

/**
 * 
 * @author Gaurav Rai Mazra
 * 
 *         <a href="https://gaurav.cc">Blog</a>
 * 
 *         <a href="https://grai.dev">About me</a>
 *
 */
public class PivotedArraySearch extends NonRecursiveBinarySearch {
	public static void main(String[] args) {
		PivotedArraySearch pivotSearch = new PivotedArraySearch();
		System.out.println(pivotSearch.search(new int[] { 4, 1 }, 1));
	}

	@Override
	public int search(int[] arr, int elementToSearch) {
		PositionDetectionStrategy positionDetectionStrategy = (lo, hi) -> lo + (hi - lo) / 2;

		int pivotIndex = findPivotIndex(arr, positionDetectionStrategy);

		if (arrayNotPivoted(pivotIndex))
			throw new IllegalArgumentException("Array is not pivoted. Use simple BinarySearch!");

		int index = divideArrayAndBinarySearch(arr, 0, pivotIndex, elementToSearch, positionDetectionStrategy);
		if (index != -1)
			return index;

		index = divideArrayAndBinarySearch(arr, pivotIndex, arr.length, elementToSearch, positionDetectionStrategy);

		if (index != -1) {
			return index + pivotIndex;
		}

		return -1;
	}

	private int divideArrayAndBinarySearch(int[] arr, int start, int end, int elementToSearch,
			PositionDetectionStrategy positionDetectionStrategy) {
		int[] copiedArray = Arrays.copyOfRange(arr, start, end);
		return binarySearch(copiedArray, 0, copiedArray.length - 1, elementToSearch, positionDetectionStrategy);
	}

	private int findPivotIndex(int[] arr, PositionDetectionStrategy positionDetectionStrategy) {
		int lo = 0;
		int hi = arr.length - 1;
		return findPivotIndex(arr, lo, hi, positionDetectionStrategy);
	}

	private int findPivotIndex(int[] arr, int lo, int hi, PositionDetectionStrategy positionDetectionStrategy) {
		if (hi > lo) {
			int mid = positionDetectionStrategy.pos(lo, hi);

			if ((mid + 1) <= hi && arr[mid] > arr[mid + 1])
				return mid + 1;
			else if ((mid - 1) >= lo && arr[mid] < arr[mid - 1])
				return mid;
			else if ((mid + 1) < hi && arr[mid] < arr[mid + 1])
				return findPivotIndex(arr, mid + 1, hi, positionDetectionStrategy);
			else
				return findPivotIndex(arr, lo, mid - 1, positionDetectionStrategy);
		}

		return -1;
	}

	private boolean arrayNotPivoted(int pivotIndex) {
		return pivotIndex == -1;
	}
}
