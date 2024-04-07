package cc.gaurav.backtrack;

import java.util.LinkedList;

public class ShortestPathInMaze {
	static class Path {
		final int row;
		final int col;
		final int depth;

		public Path(int row, int col, int depth) {
			this.row = row;
			this.col = col;
			this.depth = depth;
		}
	}

	private static final int[][] DIRS = new int[][] { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };

	public int solve(int[][] matrix, int sr, int sc, int tr, int tc) {
		if (isValid(matrix, sr, sc)) {
			return bfs(matrix, sr, sc, tr, tc);
		} else {
			return 0;
		}
	}

	private boolean isValid(int[][] matrix, int sr, int sc) {
		return sr >= 0 && sr < matrix.length && sc >= 0 && sc < matrix[sr].length && matrix[sr][sc] == 1;
	}

	private int bfs(int[][] matrix, int sr, int sc, int tr, int tc) {
		boolean[][] visited = new boolean[matrix.length][matrix[sr].length];
		LinkedList<Path> q = new LinkedList<>();
		q.offer(new Path(sr, sc, 0));
		

		Path current;
		int cr;
		int cc;
		
		int nr;
		int nc;
		while (!q.isEmpty()) {
			int size = q.size();

			for (int i = 0; i < size; i++) {
				current = q.poll();
				cr = current.row;
				cc = current.col;
				
				
				if (cr == tr && cc == tc) {
					return current.depth;
				}
					
				for (int[] dir : DIRS) {
					nr = cr + dir[0];
					nc = cc + dir[1];
					
					if (isValid(matrix, nr, nc) && !visited[nr][nc]) {
						q.offer(new Path(nr, nc, current.depth + 1));
						visited[nr][nc] = true;
					}
				}
			}
		}

		return 0;
	}
	
	
	public static void main(String[] args) {
		int[][] mat =
	        {
	            { 1, 1, 1, 1, 1, 0, 0, 1, 1, 1 },
	            { 0, 1, 1, 1, 1, 1, 0, 1, 0, 1 },
	            { 0, 0, 1, 0, 1, 1, 1, 0, 0, 1 },
	            { 1, 0, 1, 1, 1, 0, 1, 1, 0, 1 },
	            { 0, 0, 0, 1, 0, 0, 0, 1, 0, 1 },
	            { 1, 0, 1, 1, 1, 0, 0, 1, 1, 0 },
	            { 0, 0, 0, 0, 1, 0, 0, 1, 0, 1 },
	            { 0, 1, 1, 1, 1, 1, 1, 1, 0, 0 },
	            { 1, 1, 1, 1, 1, 0, 0, 1, 1, 1 },
	            { 0, 0, 1, 0, 0, 1, 1, 0, 0, 1 },
	        };
		
		ShortestPathInMaze sp = new ShortestPathInMaze();
		System.out.println(sp.solve(mat, 0, 0, 7, 5));
	}
}
