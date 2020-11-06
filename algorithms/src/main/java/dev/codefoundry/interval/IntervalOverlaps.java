package dev.codefoundry.interval;

import java.util.Arrays;

/**
 * 
 * @author Gaurav Rai Mazra {@link https://codefoundry.dev}
 *
 */
public class IntervalOverlaps {
	public int solve(int[][] intervals) {
		Arrays.sort(intervals, (int[] a, int[] b) -> {
			int cmp = Integer.compare(a[0], b[0]);

			return cmp == 0 ? Integer.compare(a[1], b[1]) : cmp;
		});

		/**
		 * intervals = [ [0, 10], [10, 30], [20, 30], [20, 40] [30, 40], ]
		 */
		int count = 0;
		int[] containingInterval = intervals.length == 0 ? new int[0] : intervals[0];
		for (int i = 1; i < intervals.length; i++) {
			if (containingInterval[1] > intervals[i][1] || containingInterval[1] > intervals[i][0]) {
				count += 1;
			} else {
				containingInterval = intervals[i];
			}
		}

		return count;
	}

	public static void main(String[] args) {
		System.out.println(new IntervalOverlaps().solve(new int[][] { { 26, 59 }, { 67, 77 }, { 70, 140 }, { 74, 109 },
				{ 4, 25 }, { 47, 98 }, { 15, 64 }, { 52, 106 }, { 23, 93 }, { 26, 99 }, { 84, 167 }, { 53, 138 },
				{ 28, 82 }, { 35, 56 }, { 81, 93 }, { 61, 105 }, { 92, 110 }, { 21, 53 }, { 93, 123 }, { 57, 101 },
				{ 87, 184 }, { 4, 54 }, { 6, 100 }, { 2, 65 }, { 18, 22 }, { 37, 104 }, { 68, 158 }, { 78, 125 },
				{ 68, 117 }, { 6, 41 }, { 56, 80 }, { 5, 90 }, { 75, 129 }, { 41, 110 }, { 8, 104 }, { 90, 137 },
				{ 23, 62 }, { 49, 143 }, { 79, 100 }, { 8, 13 }, { 6, 41 }, { 2, 9 }, { 48, 110 }, { 8, 40 },
				{ 47, 74 }, { 52, 131 }, { 28, 66 }, { 48, 98 }, { 98, 108 }, { 76, 143 }, { 8, 101 }, { 40, 134 },
				{ 80, 156 }, { 60, 145 }, { 80, 87 }, { 55, 153 }, { 81, 137 }, { 70, 108 }, { 93, 166 }, { 94, 161 },
				{ 13, 56 }, { 10, 78 }, { 4, 47 }, { 94, 167 }, { 53, 130 }, { 61, 149 }, { 38, 135 }, { 63, 95 },
				{ 60, 80 }, { 15, 114 }, { 75, 174 }, { 85, 86 }, { 74, 148 }, { 29, 73 }, { 93, 146 }, { 79, 97 },
				{ 16, 18 }, { 50, 139 }, { 30, 72 }, { 20, 114 }, { 94, 158 }, { 72, 102 }, { 57, 120 }, { 50, 115 },
				{ 58, 88 }, { 43, 137 }, { 62, 130 }, { 56, 70 }, { 98, 104 }, { 91, 167 }, { 56, 123 }, { 79, 125 },
				{ 3, 57 }, { 4, 78 }, { 12, 103 }, { 66, 130 }, { 54, 93 }, { 34, 37 }, { 71, 167 }, { 14, 73 } }));
	}
}
