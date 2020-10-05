package dev.codefoundry.tries;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Gaurav Rai Mazra {@link https://www.codefoundry.dev}
 * 
 *         Given a binary search tree, and k return kth smallest value in the
 *         root.
 *
 */
public class KthSmallestNumber {
	class Tree {
		int val;
		Tree left;
		Tree right;
	}

	public int solve(Tree root, int k) {
		List<Integer> values = new ArrayList<Integer>();
		inOrder(root, values, k);
		return values.get(k);
	}

	public void inOrder(Tree root, List<Integer> elements, int k) {
		if (elements.size() <= k) {
			if (root.left != null)
				inOrder(root.left, elements, k);

			elements.add(root.val);

			if (root.right != null) {
				inOrder(root.right, elements, k);
			}
		}
	}
}
