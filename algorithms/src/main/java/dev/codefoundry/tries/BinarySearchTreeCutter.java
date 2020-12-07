package dev.codefoundry.tries;

public class BinarySearchTreeCutter {
	class Tree {
		int val;
		Tree left;
		Tree right;

		@Override
		public String toString() {
			return "[" + this.val + ", left: " + this.left + ", right: " + this.right + "]";
		}
	}

	public Tree solve(Tree root, int lo, int hi) {
		return cut(root, null, true, lo, hi);
	}

	private Tree cut(Tree node, Tree parent, boolean left, int lo, int hi) {
		if (node == null)
			return null;

		if (node.val < lo) {
			while (node != null && node.val < lo) {
				node = node.right;
			}
		} 
		
		if (node.val > hi) {
			while (node != null && node.val > hi) {
				node = node.left;
			}
		}

		if (node != null) {
			cut(node.left, node, true, lo, hi);
			cut(node.right, node, false, lo, hi);
		}

		if (parent != null) {
			if (left) {
				parent.left = node;
			} else {
				parent.right = node;
			}
		}

		return node;
	}
	
	private Tree t(int val, Tree left, Tree right) {
		Tree t = new Tree();
		t.val = val;
		t.left = left;
		t.right = right;
		
		return t;
	}

	public static void main(String[] args) {
		BinarySearchTreeCutter c = new BinarySearchTreeCutter();
		Tree root = c.t(3, c.t(0, null, c.t(2, null,  null)), c.t(6, c.t(4, null, null), null));
		System.out.println(c.solve(root, 3, 5));
	}
}
