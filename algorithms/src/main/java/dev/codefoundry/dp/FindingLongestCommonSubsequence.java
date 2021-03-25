package dev.codefoundry.dp;

public class FindingLongestCommonSubsequence {
	private int[][] lcs(String a, String b) {
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
	
	private String lcsOf(String a, String b, int m, int n, int[][] lcs) {
		if (m == 0 || n == 0) {
			return "";
		}
		
		if (a.charAt(m - 1) == b.charAt(n - 1)) {
			return lcsOf(a, b, m - 1, n - 1, lcs) + a.charAt(m - 1);
		}
		
		
		if (lcs[m - 1][n] > lcs[m][n - 1]) {
			return lcsOf(a, b, m - 1, n, lcs);
		} else {
			return lcsOf(a, b, m, n - 1, lcs);
		}
		
	}
	
	public String solve(String a, String b) {
		int m = a.length();
		int n = b.length();
		int[][] lcs = lcs(a, b);
		
		return lcsOf(a, b, m, n, lcs);
	}
	
	public static void main(String[] args) {
		System.out.println(new FindingLongestCommonSubsequence().solve("XMJYAUZ", "MZJAWXU"));
	}
}
