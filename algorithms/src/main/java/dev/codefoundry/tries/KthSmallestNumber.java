package dev.codefoundry.tries;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * 
 * @author Gaurav Rai Mazra {@link https://www.codefoundry.dev}
 * 
 *         Given a binary search tree, and k return kth smallest value in the
 *         root.
 *
 */
public class KthSmallestNumber {

	public int solve(TreeNode root, int k) {
		return inOrderWithMorris(root, k);
	}
	
	public int inOrderWithMorris(TreeNode root, int k) {
		int i = 0;
		for (Integer value : new MorrisInOrderIterator().inOrderMorisTraversalIterable(root)) {
			if (i == k) {
				return value;
			} else i++;
		}
		
		throw new NoSuchElementException();
	}

	public void inOrder(TreeNode root, List<Integer> elements, int k) {
		if (elements.size() <= k) {
			if (root.left() != null)
				inOrder(root.left(), elements, k);

			elements.add(root.val());

			if (root.right() != null) {
				inOrder(root.right(), elements, k);
			}
		}
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(10);
		TreeNode left = new TreeNode(5);
		left.left(new TreeNode(2));
		left.right(new TreeNode(7));
		TreeNode right = new TreeNode(12);
		root.left(left);
		root.right(right);
		
		System.out.println(new KthSmallestNumber().solve(root, 3));
	}
}
