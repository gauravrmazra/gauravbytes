package cc.gaurav.list;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 
 * @author Gaurav Rai Mazra
 * {@link Convert Binary Tree into LinkedList using inOrder Traversal}
 *
 */
public class BinaryTreeToLinkedList {
	class LLNode {
		int val;
		LLNode next;
		
		@Override
		public String toString() {
			return this.val + (this.next != null ? " -> " + this.next.toString() : "");
		}
	}
	
	class Tree {
		int val;
		Tree left;
		Tree right;
	}
	
	
	public LLNode solve(Tree root) {
        LLNode fakeRoot = new LLNode();
        AtomicReference<LLNode> node = new AtomicReference<BinaryTreeToLinkedList.LLNode>(fakeRoot);
        inOrder(root, node);
        return fakeRoot.next;
    }
    
    private void inOrder(Tree node, AtomicReference<LLNode> ref) {
    	if (node == null) return;
    	
        if (node.left != null)
			inOrder(node.left, ref);

        LLNode n = new LLNode();
        n.val = node.val;
		ref.get().next = n;
		ref.set(n);

		if (node.right != null)
			inOrder(node.right, ref);
    }
    
    private Tree tree(int val, Tree left, Tree right) {
    	Tree t = new Tree();
    	t.val = val;
    	t.left = left;
    	t.right = right;
    	return t;
    }
    
    public static void main(String[] args) {
    	BinaryTreeToLinkedList btl = new BinaryTreeToLinkedList();
		Tree root = btl.tree(1, btl.tree(0, null, null), null);
		System.out.println(btl.solve(root));
	}
}
