package cc.gaurav.tries;

import java.util.Iterator;


public class TreeIterable implements Iterable<TreeIterable.Tree> {
	static class Tree {
		int val;
		Tree left;
		Tree right;
	}
	
	private final Tree root;
	
	public TreeIterable(Tree root) {
		this.root = root;
	}
	
	
	@Override
	public Iterator<TreeIterable.Tree> iterator() {
		return new Iterator<TreeIterable.Tree>() {
			@Override
			public boolean hasNext() {
				return root != null;
			}
			
			@Override
			public Tree next() {
				Tree node = root;
				Tree temp = null;
				while(node != null) {
					if (node.left != null) {
						temp = node.left;
						
						while (temp != null && temp.right != null && temp.right != node) {
							temp = temp.right;
						}
						
						if (temp.right != null) {
							temp.right = null;
							Tree t = node;
							node = node.right;
							return t;
						} else {
							temp.right = node;
							node = node.left;
						}
					} else {
						Tree t = node;
						node = node.right;
						return t;
					}
				}
				return null;
			}
		};
	}
	
	public static TreeIterable of(Tree root) {
		return new TreeIterable(root);
	}
	
	public static void main(String[] args) {
		Tree root = new Tree();
		root.val = 5;
		
		Tree rootLeft = new Tree();
		root.left = rootLeft;
		
		rootLeft.val = 2;
		
		Tree rootLeftRight = new Tree();
		rootLeft.right = rootLeftRight;
		rootLeftRight.val = 3;
		
		Tree rootRight = new Tree();
		root.right = rootRight;
		rootRight.val = 10;
		
		Tree rootRightLeft = new Tree();
		rootRight.left = rootRightLeft;
		rootRightLeft.val = 7;
		
		Tree rootRightRight = new Tree();
		rootRight.right = rootRightRight;
		rootRightRight.val = 13;
		
		for (Tree t : TreeIterable.of(root)) {
			System.out.println(t.val);
		}
	}
}
