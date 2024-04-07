package cc.gaurav.backtrack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 
 * @author Gaurav Rai Mazra {@link https://gaurav.cc}
 * 
 *         Given M * N boggle board, find list of all possible words that can be
 *         formed by a sequence of adjacent characters on the board
 *
 */
public class GenerateListOfPossibleWords {
	static class Trie {
		Map<Character, Trie> children = new HashMap<>();
		private boolean isEnd;

		public void insert(String word) {
			Trie current = this;

			for (char c : word.toCharArray()) {
				current = current.children.computeIfAbsent(c, key -> new Trie());
			}
			current.isEnd = true;
		}

		@Override
		public String toString() {
			return "[ " + this.children.toString() + " : " + this.isEnd + " ]";
		}
	}

	private static final int[][] DIRS = new int[][] { { -1, -1 }, { -1, 1 }, { -1, 0 }, { 0, -1 }, { 1, -1 }, { 0, 1 },
			{ 1, 0 }, { 1, 1 } };

	public Set<String> solve(char[][] board, List<String> words) {
		Trie root = new Trie();

		for (String word : words) {
			root.insert(word);
		}

		int rows = board.length;
		int cols = board[0].length;

		boolean[][] visited = new boolean[rows][cols];
		Set<String> paths = new HashSet<>();

		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {
				if (root.children.containsKey(board[row][col])) {
					searchWord(root.children.get(board[row][col]), board, row, col, visited,
							Character.toString(board[row][col]), paths);
				}
			}
		}

		return paths;
	}

	private void searchWord(Trie node, char[][] board, int row, int col, boolean[][] visited, String path,
			Set<String> paths) {

		if (node.isEnd) {
			paths.add(path);
		}

		visited[row][col] = true;

		for (Map.Entry<Character, Trie> entry : node.children.entrySet()) {
			for (int[] dir : DIRS) {
				if (isValid(board, dir[0] + row, dir[1] + col, visited, entry.getKey())) {
					searchWord(entry.getValue(), board, dir[0] + row, dir[1] + col, visited, path + entry.getKey(),
							paths);
				}
			}
		}
		visited[row][col] = false;
	}

	private boolean isValid(char[][] board, int r, int c, boolean[][] visited, char value) {
		return r >= 0 && r < board.length && c >= 0 && c < board[r].length && !visited[r][c] && board[r][c] == value;
	}

	public static void main(String[] args) {
		GenerateListOfPossibleWords generator = new GenerateListOfPossibleWords();
		System.out.println(generator.solve(new char[][] { { 'M', 'S', 'E', 'F' }, { 'R', 'A', 'T', 'D' },
				{ 'L', 'O', 'N', 'E' }, { 'K', 'A', 'F', 'B' } }, Arrays.asList("START", "NOTE", "SAND", "STONED")));
	}
}
