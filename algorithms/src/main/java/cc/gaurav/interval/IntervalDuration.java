package cc.gaurav.interval;

import java.util.Arrays;

/**
 * 
 * @author Gaurav Rai Mazra 
 * {@link https://gaurav.cc}
 *
 */
public class IntervalDuration {
	public int solve(int[][] intervals) {
		Arrays.sort(intervals, (int[] a, int[] b) -> Integer.compare(a[0], b[0]));

		int start = intervals[0][0];
		int end = intervals[0][1];
		int sum = 0;

		for (int i = 0; i < intervals.length; i++) {
			if (intervals[i][0] <= end) {
				end = Math.max(end, intervals[i][1]);
			} else {
				sum += (end - start) + 1;
				start = intervals[i][0];
				end = intervals[i][1];
			}

			if (i + 1 == intervals.length) {
				sum += (end - start) + 1;
			}
		}

		return sum;
	}
}
