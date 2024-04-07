package cc.gaurav.interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * @author Gaurav Rai Mazra {@link https://gaurav.cc}
 *
 *         You are given a list of unique integers nums. Return a sorted two
 *         dimensional list of integers where each list represents an inclusive
 *         interval summarizing integers that are contiguous in nums.
 * 
 *         e.g. nums = [1, 2, 5, 9, 10, 11, 12, 13]
 * 
 *         Output should be [ [1, 2], [5, 5], [9, 13] ]
 */
public class ContiguousIntervals {
	public int[][] solve(int[] nums) {
		if (nums.length <= 1) {
			return nums.length == 1 ? new int[][] { { nums[0], nums[0] } } : new int[][] {};
		}

		Arrays.sort(nums);

		List<int[]> groups = new ArrayList<>();
		int start = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if (nums[i - 1] + 1 != nums[i]) {
				groups.add(new int[] { start, nums[i - 1] });
				start = nums[i];
			}

			if (i + 1 == nums.length) {
				groups.add(new int[] { start, nums[i] });
			}
		}

		return groups.toArray(new int[groups.size()][2]);
	}
}
