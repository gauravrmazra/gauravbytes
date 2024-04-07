package cc.gaurav.tries;

import java.util.concurrent.atomic.AtomicInteger;

public class CountMaximalValueRoots {
	class Tree {
		int val;
		Tree left;
		Tree right;
	}

	public int solve(Tree root) {
		AtomicInteger count = new AtomicInteger(0);
		AtomicInteger biggestValue = new AtomicInteger(Integer.MIN_VALUE);

		traversal(root, count, biggestValue);

		return count.get();
	}

	private void traversal(Tree root, AtomicInteger count, AtomicInteger biggestValue) {
		if (root == null)
			return;

		traversal(root.left, count, biggestValue);

		int leftBiggest = biggestValue.get();

		biggestValue.set(Integer.MIN_VALUE);
		traversal(root.right, count, biggestValue);
		int rightBiggest = biggestValue.get();
		if (isLeaf(root)) {
			biggestValue.set(Math.max(biggestValue.get(), root.val));
			count.incrementAndGet();
		} else if (isBigger(root.left, root.val) && isBigger(root.right, root.val) && root.val >= leftBiggest
				&& root.val >= rightBiggest) {
			biggestValue.set(root.val);
			count.incrementAndGet();
		} else {
			biggestValue.set(Math.max(leftBiggest, rightBiggest));
		}
	}

	private boolean isLeaf(Tree node) {
		return node.left == null && node.right == null;
	}

	private boolean isBigger(Tree node, int target) {
		return node == null || node.val <= target;
	}

	private Tree t(int val, Tree left, Tree right) {
		Tree t = new Tree();
		t.val = val;
		t.left = left;
		t.right = right;
		return t;
	}

	public static void main(String[] args) {
		CountMaximalValueRoots r = new CountMaximalValueRoots();
		// Tree root = r.t(6, r.t(3, null, null),r.t(2, r.t(6, null, null), r.t(4, null,
		// null)));
		// Tree root = r.t(1, r.t(0, null, r.t(2, null, null)), null);

		Tree root = r.t(1, r.t(3, null, null), r.t(1, null, r.t(1, null, null)));
		System.out.println(r.solve(root));

	}
}
