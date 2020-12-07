package dev.codefoundry.tries;

public class LeftMostDeepestTreeNode {
	class Tree {
		int val;
		Tree left;
		Tree right;
	}

	public int solve(Tree root) {
		if (root == null)
			return 0;

		int height = height(root);
		Integer[] result = traversal(root, height, 1);
		return result[0] != null ? result[0] : 0;
	}

	private Integer[] traversal(Tree node, int height, int level) {
		if (node == null)
			return null;

		if (level + 1 == height && (node.left != null || node.right != null)) {
			Integer[] result = new Integer[1];
			if (node.left != null) {
				result[0] = node.left.val;
			} else if (node.right != null) {
				result[0] = node.right.val;
			}

			return result;

		}

		Integer[] left = traversal(node.left, height, level + 1);
		Integer[] right = traversal(node.right, height, level + 1);

		return left != null ? left : right;
	}

	private int height(Tree node) {
		if (node == null)
			return 0;

		return 1 + Math.max(height(node.left), height(node.right));
	}

	private Tree t(int val, Tree left, Tree right) {
		Tree t = new Tree();
		t.left = left;
		t.right = right;
		t.val = val;
		return t;
	}

	public static void main(String[] args) {
		LeftMostDeepestTreeNode l = new LeftMostDeepestTreeNode();
		// [1, [3, null, [5, null, null]], [4, [6, null, null], [0, null, null]]]

		Tree root = l.t(88, l.t(3, null, l.t(5, null, null)), l.t(4, l.t(6, null, null), l.t(0, null, null)));

		System.out.println(l.solve(root));
	}
}
