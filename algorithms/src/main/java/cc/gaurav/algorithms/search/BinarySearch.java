package cc.gaurav.algorithms.search;

/**
 * 
 * @author Gaurav Rai Mazra
 *         {@linkplain https://gaurav.cc}
 */
public class BinarySearch implements Search {

	public static interface PositionDetectionStrategy {
		int pos(int lo, int hi);
	}

	@Override
	public int search(final int[] arr, final int elementToSearch) {
		PositionDetectionStrategy positionDetectionStrategy = (lo, hi) -> lo + (hi - lo) / 2;
		return binarySearch(arr, 0, arr.length - 1, elementToSearch, positionDetectionStrategy);
	}

	int binarySearch(final int[] arr, final int lo, final int hi, final int elementToSearch,
			final PositionDetectionStrategy positionDetectionStrategy) {
		if (hi > lo) {
			int mid = positionDetectionStrategy.pos(lo, hi);

			if (elementToSearch == arr[mid])
				return mid;
			else if (elementToSearch < arr[mid])
				return binarySearch(arr, lo, mid - 1, elementToSearch, positionDetectionStrategy);
			else
				return binarySearch(arr, mid + 1, hi, elementToSearch, positionDetectionStrategy);
		}

		return -1;
	}
}
