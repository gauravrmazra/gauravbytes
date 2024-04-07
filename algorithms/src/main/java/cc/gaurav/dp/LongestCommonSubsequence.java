package cc.gaurav.dp;

import java.util.Map;

/**
 * 
 * @author Gaurav Rai Mazra {@link https://gaurav.cc}
 *
 */
public class LongestCommonSubsequence {
	public int solve(String a, String b) {
		return bottomup(a, b);
	}

	private int bottomup(String a, String b) {
		int m = a.length() + 1;
		int n = b.length() + 1;

		int[][] dp = new int[m][n];
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (a.charAt(i - 1) == b.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}

		return dp[m - 1][n - 1];
	}

	private int topDown(String a, String b, int m, int n, Map<String, Integer> lookup) {
		if (m < 0 || n < 0) {
			return 0;
		}

		String key = m + "|" + n;

		if (!lookup.containsKey(key)) {
			if (a.charAt(m) == b.charAt(n)) {
				lookup.put(key, topDown(a, b, m - 1, n - 1, lookup) + 1);
			} else {
				lookup.put(key, Math.max(topDown(a, b, m, n - 1, lookup), topDown(a, b, m - 1, n, lookup)));
			}
		}

		return lookup.get(key);
	}

}
