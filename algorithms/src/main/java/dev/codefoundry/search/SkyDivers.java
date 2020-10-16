package dev.codefoundry.search;

import java.util.function.Predicate;

public class SkyDivers {
	public int solve(final int[] nums, final int k) {
		int sum = 0;
		int max = 0;
		for (int num : nums) {
			if (max < num) max = num;
			
			sum += num;
		}
		int lo = max;
		int hi = sum;
		int mid;
		Predicate<Integer> condition = (Integer v) -> {
			int total = 0;
			int count = 1;
			for (int num : nums) {
				total += num;
				if (total > v) {
					total = num;
					count += 1;
					
					if ( count > k) return false;
				}
			}
			return true;
		};
		
		while (lo < hi) {
			mid = lo + (hi - lo) / 2;
			if (condition.test(mid)) {
				hi = mid;
			} else {
				lo = mid + 1;
			}
		}
		return lo;
	}
}
