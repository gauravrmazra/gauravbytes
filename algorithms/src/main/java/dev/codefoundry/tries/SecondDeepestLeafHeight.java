package dev.codefoundry.tries;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

public class SecondDeepestLeafHeight {
	class Tree {
		int val;
		Tree left;
		Tree right;

		public String toString() {
			return "[root: " + val + ", left: " + (left == null ? "null" : left.val) + ", right"
					+ (right == null ? "null" : right.val) + "]";
		}
	}

	public int solve(Tree root) {
		Set<Integer> depths = new TreeSet<>();
		traversal(root, 0, depths);

		if (depths.size() == 0)
			return 0;

		if (depths.size() == 1)
			return new ArrayList<>(depths).get(0);

		System.out.println(depths);

		return new ArrayList<>(depths).get(depths.size() - 2);

	}

	private void traversal(Tree root, int depth, Set<Integer> depths) {
		if (root == null) {
			return;
		}

		if (root.left == null && root.right == null) {
			System.out.println("Root:   " + root.val);
			depths.add(depth);
		} else {
			depth += 1;
			if (root.left != null) {
				traversal(root.left, depth, depths);
			}
			if (root.right != null) {
				traversal(root.right, depth, depths);
			}

		}
	}

	private Tree t(int val, Tree left, Tree right) {
		Tree t = new Tree();
		t.val = val;
		t.left = left;
		t.right = right;
		return t;
	}

	public static void main(String[] args) {
		SecondDeepestLeafHeight r = new SecondDeepestLeafHeight();
		Tree root = r.t(0, r.t(1, null, r.t(2, null, r.t(3, r.t(4, null, null), null))),
				r.t(1, r.t(2, null, null), null));

		System.out.println(r.solve(root));
	}
}
