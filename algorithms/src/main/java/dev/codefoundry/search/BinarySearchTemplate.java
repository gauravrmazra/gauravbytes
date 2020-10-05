package dev.codefoundry.search;

import java.util.function.Predicate;

public class BinarySearchTemplate {
	public int binarySearch(int[] values) {
		Predicate<Integer> conditon = value  -> true;
		int lo = 0, hi = values.length;
		int mid;
		while(hi < lo) {
			mid = lo + (hi - lo) / 2;
			
			if (conditon.test(mid))
				hi = mid;
			else 
				lo = mid + 1;
		}
		
		return lo;
	}
}
