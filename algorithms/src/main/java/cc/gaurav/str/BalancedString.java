package cc.gaurav.str;

public class BalancedString {
	public int solve(String s) {
		int left = 2;
		int right = s.length() - 1;
		int mid;
		while (left < right) {
			mid = left + (right - left) / 2;
			if (isPossible(s, mid)) {
				right = mid;
			} else {
				left = mid + 1;
			}
		}

		return left == 1 ? -1 : left;
	}

	private boolean isPossible(String s, int windowSize) {
		int start;
		int end;
		for (int i = 0; i < s.length() - windowSize + 1; i++) {
			int[] lower = new int[26];
			int[] upper = new int[26];
			start = i;
			end = start + windowSize + 1;

			while (start < end && start < s.length()) {
				if (Character.isUpperCase(s.charAt(start))) {
					upper[s.charAt(start) - 'A']++;
				} else {
					lower[s.charAt(start) - 'a']++;
				}
				start++;
			}

			if (matches(lower, upper))
				return true;
		}

		return false;
	}

	private boolean matches(int[] a, int[] b) {
		for (int i = 0; i < a.length; i++) {
			if ((a[i] == 0 || b[i] == 0) && (a[i] != b[i]))
				return false;
		}

		return true;
	}

	public static void main(String[] args) {
		BalancedString bs = new BalancedString();

		System.out.println("azABaabza: " + bs.solve("azABaabza"));
		System.out.println("TacoCat: " + bs.solve("TacoCat"));
		System.out.println("AcZcbaBz: " + bs.solve("AcZcbaBz"));
		System.out.println("abcdefghijklmnopqrstuvwxyz: " + bs.solve("abcdefghijklmnopqrstuvwxyz"));
	}
}
