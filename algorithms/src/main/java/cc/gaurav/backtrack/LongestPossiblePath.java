package cc.gaurav.backtrack;

public class LongestPossiblePath {
	/*
	 * int mat[M][N] = { { 1, 1, 1, 1, 1, 1, 0, 1, 1, 1 }, { 1, 0, 1, 0, 1, 1, 1, 0,
	 * 1, 1 }, { 1, 1, 1, 0, 1, 1, 0, 1, 0, 1 }, { 0, 0, 0, 0, 1, 0, 0, 1, 0, 0 }, {
	 * 1, 0, 0, 0, 1, 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1, 1, 1, 1, 1, 0 }, { 1, 0, 0,
	 * 0, 1, 0, 0, 1, 0, 1 }, { 1, 0, 1, 1, 1, 1, 0, 0, 1, 1 }, { 1, 1, 0, 0, 1, 0,
	 * 0, 0, 0, 1 }, { 1, 0, 1, 1, 1, 1, 0, 1, 0, 0 } };
	 * 
	 * source= 0,0 destination 5,7
	 * 
	 * constraints - 4 direction - 1 cell - no cycle
	 */
	int max = 0;
	private final int[][] DIR = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

	public int findLenLongestPath(int[][] mat, int sr, int sc, int tr, int tc) {
		if (mat[sr][sc] == 0) {
			return 0;
		}

		searchMatrix(mat, sr, sc, tr, tc, 0);
		return max;
	}

	private boolean isValid(int[][] matrix, int r, int c) {
		return r >= 0 && r < matrix.length && c >= 0 && c < matrix[r].length && matrix[r][c] == 1;
	}

	private void searchMatrix(int[][] mat, int sr, int sc, int tr, int tc, int result) {

		if (sr == tr && sc == tc) {
			max = Math.max(result, max);
			return;
		}

		mat[sr][sc] = 0;

		for (int[] d : DIR) {
			int newsr = d[0] + sr;
			int newsc = d[1] + sc;
			if (isValid(mat, newsr, newsc)) {
				searchMatrix(mat, newsr, newsc, tr, tc, result + 1);
			}
		}

		mat[sr][sc] = 1;
	}
}
