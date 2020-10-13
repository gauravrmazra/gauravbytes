package dev.codefoundry.string;

public class DeleteCharsToEqualizeStrings {
	public int solve(String a, String b) {
        int[][] dp = new int[a.length() + 1][b.length() + 1];

        for (int i = 0; i <= a.length(); i++) {
            for (int j = 0; j <= b.length(); j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = i + j;
                } else if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }

        return dp[a.length()][b.length()];
    }
	
	public static void main(String[] args) {
		System.out.println(new DeleteCharsToEqualizeStrings().solve("a", "bb"));
	}
}
