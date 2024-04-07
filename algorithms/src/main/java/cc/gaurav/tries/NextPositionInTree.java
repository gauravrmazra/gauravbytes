package cc.gaurav.tries;

/**
 * 
 * @author Gaurav Rai Mazra
 * {@link https://gaurav.cc}
 *
 */
public class NextPositionInTree {
	
	static class Node {
	    public int val;
	    public Node left;
	    public Node right;
	    public Node next;
	
	    public Node() {}
	    
	    public Node(int _val) {
	        val = _val;
	    }
	
	    public Node(int _val, Node _left, Node _right, Node _next) {
	        val = _val;
	        left = _left;
	        right = _right;
	        next = _next;
	    }
	    
	    @Override
    	public String toString() {
		return "[ Node: " + this.val + ", left: " + left + ", right: "+ right + ", next: " + (next == null ? null: next.val) + "]";
    	}
	}
	
	public Node connect(Node root) {
        return solutionWithConstantSpace(root);
    }
    
    private Node solutionWithConstantSpace(Node root) {
        if (root == null) return root;
        
        recursiveLinking(root, null, false);
        
        return root;
    }
    
    private void recursiveLinking(Node node, Node parent, boolean left) {
        if (node == null) return;
        
        //System.out.println("NodeVal: " + node.val + ", ParentVal: " + (parent == null ? null : parent.val));
        
        if (parent != null) {
            node.next = left ? parent.right : parent.left;
        }
        
        recursiveLinking(node.left, node, true);
        recursiveLinking(node.right, node, false);
    }
    
    public static void main(String[] args) {
    	//[1,2,3,4,5,6,7]
    	Node root = new Node(1, new Node(2, new Node(4), new Node(5), null),  new Node(3, new Node(6), new Node(7), null), null);	
	
    	System.out.println(new NextPositionInTree().connect(root));
    }

}
