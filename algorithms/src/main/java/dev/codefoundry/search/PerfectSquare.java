package dev.codefoundry.search;

public class PerfectSquare {
	public boolean solve(int n) {
		if (n == 0 || n == 1)
			return true;

		long low = 0;
		long hi = n;
		long mid;

		long multi;
		long target = n;
		while (low < hi) {
			mid = low + (hi - low) / 2l;
			multi = mid * mid;

			if (multi == target)
				return true;
			else if (multi > target) {
				hi = mid;
			} else {
				low = mid + 1;
			}
		}

		return false;
	}
	
	public static void main(String[] args) {
		System.out.println(new PerfectSquare().solve(25));
	}
}
