package cc.gaurav.interval;

import java.util.Arrays;

/**
 * 
 * @author Gaurav Rai Mazra
 * {@link https://gaurav.cc}
 *
 */
public class LongestInterval {
	public int solve(int[][] intervals) {
		if (intervals.length <= 1)
			return intervals.length == 1 ? (intervals[0][1] - intervals[0][0]) + 1 : 0;

		Arrays.sort(intervals, (int[] a, int[] b) -> Integer.compare(a[0], b[0]));

		int start = intervals[0][0];
		int end = intervals[0][1];
		int max = end - start + 1;

		for (int i = 1; i < intervals.length; i++) {
			if (intervals[i][0] <= end) {
				end = Math.max(end, intervals[i][1]);
			} else {
				max = Math.max(max, (end - start) + 1);
				start = intervals[i][0];
				end = intervals[i][1];
			}
		}

		return Math.max(max, (end - start) + 1);
	}

	public static void main(String[] args) {
		/**
		 * [1, 5], [3, 8], [4, 5], [10, 13], [11, 27]
		 */
		LongestInterval i = new LongestInterval();
		System.out.println(i.solve(new int[][] { { 3, 8 }, { 4, 5 }, { 1, 5 }, { 11, 27 }, { 10, 13 } }));
	}
}
