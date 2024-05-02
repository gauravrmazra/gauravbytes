package cc.gaurav.algorithms.search;

import static java.lang.Math.floor;
import static java.lang.Math.sqrt;
/**
 * 
 * @author Gaurav Rai Mazra {@linkplain https://gaurav.cc}
 *
 */
public class JumpSearch implements Search {

	@Override
	public int search(final int[] arr, final int elementToSearch) {
		int step = (int) floor(sqrt(elementToSearch));
		return jumpSearch(arr, elementToSearch, step);
	}

	private int jumpSearch(final int[] arr, final int elementToSearch, final int step) {
		int curr = 0;
		int prev = 0;
		for (; curr < arr.length; prev = curr, curr += step) {
			if (elementToSearch == arr[curr])
				return curr;
			else if (arr[curr] > elementToSearch) break;
		}
		
		// Linear Scan from previous index to current index
		for (int j = prev; j < curr; j++) {
			if (elementToSearch == arr[j])
				return j;
		}
		
		return -1;
	}
}
