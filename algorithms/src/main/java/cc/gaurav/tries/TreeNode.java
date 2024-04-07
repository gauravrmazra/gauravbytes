package cc.gaurav.tries;

/**
 * 
 * @author Gaurav Rai Mazra
 * {@link https://gaurav.cc}
 *
 */
public class TreeNode {
	private int val;
	private TreeNode left;
	private TreeNode right;
	
	public TreeNode(int val) {
		this(val, null, null);
	}
	
	public TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
	
	public TreeNode left() {
		return this.left;
	}
	
	public void left(TreeNode node) {
		this.left = node;
	}
	
	public int val() {
		return this.val;
	}
	
	public TreeNode right() {
		return this.right;
	}
	
	public void right(TreeNode node) {
		this.right = node;
	}
}
