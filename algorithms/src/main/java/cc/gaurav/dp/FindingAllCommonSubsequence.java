package cc.gaurav.dp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FindingAllCommonSubsequence {
	private int[][] lcsLength(String a, String b) {
		int m = a.length() + 1;
		int n = b.length() + 1;

		int[][] lcs = new int[m][n];

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (a.charAt(i - 1) == b.charAt(j - 1)) {
					lcs[i][j] = lcs[i - 1][j - 1] + 1;
				} else {
					lcs[i][j] = Math.max(lcs[i - 1][j], lcs[i][j - 1]);
				}
			}
		}

		return lcs;
	}

	private List<String> solve(String a, String b) {
		return lcs(a, b, a.length(), b.length(), lcsLength(a, b));
	}

	private List<String> lcs(String a, String b, int m, int n, int[][] lcsLength) {
		if (m == 0 || n == 0)
			return new ArrayList<>(Collections.nCopies(1, ""));

		if (a.charAt(m - 1) == b.charAt(n - 1)) {
			List<String> values = lcs(a, b, m - 1, n - 1, lcsLength);

			for (int i = 0; i < values.size(); i++) {
				values.set(i, values.get(i) + a.charAt(m - 1));
			}

			return values;
		}

		if (lcsLength[m - 1][n] > lcsLength[m][n - 1]) {
			return lcs(a, b, m - 1, n, lcsLength);
		}

		if (lcsLength[m][n - 1] > lcsLength[m - 1][n]) {
			return lcs(a, b, m, n - 1, lcsLength);
		}

		List<String> left = lcs(a, b, m - 1, n, lcsLength);
		List<String> right = lcs(a, b, m, n - 1, lcsLength);

		left.addAll(right);

		return left;

	}

	public static void main(String[] args) {
		FindingAllCommonSubsequence cc = new FindingAllCommonSubsequence();
		System.out.println(cc.solve("ABCBDAB", "BDCABA"));
	}
}
