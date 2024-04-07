package cc.gaurav.backtrack;

import java.util.concurrent.atomic.AtomicInteger;

public class UniquePathInMaze {
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
	
	private final int[][] DIR = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

	public int getUniquePathsCount(int[][] mat, int sr, int sc, int tr, int tc) {
		if (mat[sr][sc] == 0) {
			return 0;
		}
		
		AtomicInteger counter = new AtomicInteger(0);

		searchUniquePaths(mat, sr, sc, tr, tc, counter);
		return counter.get();
	}

	private boolean isValid(int[][] matrix, int r, int c) {
		return r >= 0 && r < matrix.length && c >= 0 && c < matrix[r].length && matrix[r][c] == 1;
	}
	

	private void searchUniquePaths(int[][] mat, int sr, int sc, int tr, int tc, AtomicInteger count) {

		if (sr == tr && sc == tc) {
			count.getAndIncrement();
			return;
		}

		mat[sr][sc] = 0;

		for (int[] d : DIR) {
			int newsr = d[0] + sr;
			int newsc = d[1] + sc;
			if (isValid(mat, newsr, newsc)) {
				searchUniquePaths(mat, newsr, newsc, tr, tc, count);
			}
		}

		mat[sr][sc] = 1;
	}
	
	public static void main(String[] args) {
		int maze[][] =
	        {
	            { 1, 1, 1, 1 },
	            { 1, 1, 0, 1 },
	            { 0, 1, 0, 1 },
	            { 1, 1, 1, 1 }
	        };
		UniquePathInMaze up = new UniquePathInMaze();
		System.out.println(up.getUniquePathsCount(maze, 0, 0, maze.length - 1, maze[0].length - 1));
	}
}
