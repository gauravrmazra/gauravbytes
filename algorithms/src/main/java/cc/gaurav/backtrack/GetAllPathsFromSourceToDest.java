package cc.gaurav.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class GetAllPathsFromSourceToDest {
	private static final int[][] DIRS = new int[][] { { 1, 0 }, { 0, 1 }, { 1, 1 } };

	public List<Integer[]> getAllPaths(int[][] matrix, int sr, int sc, int tr, int tc) {
		List<Integer[]> results = new ArrayList<>();
		dfs(matrix, sr, sc, tr, tc, new LinkedList<>(), results);
		return results;
	}

	private boolean isValid(int[][] matrix, int cr, int cc) {
		return cr >= 0 && cr < matrix.length && cc >= 0 && cc < matrix[cr].length;
	}

	private void dfs(int[][] matrix, int cr, int cc, int tr, int tc, LinkedList<Integer> q, List<Integer[]> results) {

		q.addLast(matrix[cr][cc]);

		if (cr == tr && cc == tc) {
			results.add(q.toArray(new Integer[q.size()]));
		} else {
			int nr;
			int nc;
			for (int[] dir : DIRS) {
				nr = dir[0] + cr;
				nc = dir[1] + cc;
				if (isValid(matrix, nr, nc)) {
					dfs(matrix, nr, nc, tr, tc, q, results);
				}
			}
		}
		q.removeLast();
	}

	public static void main(String[] args) {
		GetAllPathsFromSourceToDest gap = new GetAllPathsFromSourceToDest();
		int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		;

		List<Integer[]> allPaths = gap.getAllPaths(matrix, 0, 0, matrix.length - 1, matrix[0].length - 1);

		for (Integer[] path : allPaths) {
			System.out.println(Arrays.deepToString(path));
		}
	}

}
