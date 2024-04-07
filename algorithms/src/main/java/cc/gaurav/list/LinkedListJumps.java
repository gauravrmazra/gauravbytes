package cc.gaurav.list;

/**
 * 
 * @author Gaurav Rai Mazra
 * {@link https://gaurav.cc}
 *
 * Jumping in the SinglyLinkedList at the value on that index, if there is no option to move to that element then next point to null
 * 
 * E.g. you have a list 1 -> 2 -> 7 -> 4 -> 8
 * The desired output is 1 -> 2 -> 4
 */
public class LinkedListJumps {

	class LLNode {
		int val;
		LLNode next;
		
		@Override
		public String toString() {
			return "[data=" + val + ", next:[" + (next != null ? next.toString() : "") + "]]";
		}
	}
	
	public LLNode solve(LLNode node) {
		LLNode current;
		LLNode previous;
		current = previous = node;
		int jumpNodes = current.val;
		
		while(current != null && jumpNodes >= 0) {
			jumpNodes--;
			if (jumpNodes == 0) {
				previous.next = current.next;
				previous = previous.next;
				jumpNodes = previous != null ? previous.val : 0;
			}
			current = current.next;
		}
		
		if (jumpNodes != 0) {
			previous.next = null;
		}
		
		
		return node;
	}
	
	static LLNode lNode(int data, LLNode next, LinkedListJumps b) {
		LLNode node = b.new LLNode();
		node.val = data;
		node.next = next;
		return node;
	}
	
	
	//Test function only
	public static void main(String[] args) {
		LinkedListJumps jumps = new LinkedListJumps();
		LLNode node = lNode(1, lNode(2, lNode(9, lNode(4, lNode(8, lNode(1, lNode(1, lNode(1, lNode(1, lNode(1, lNode(1, lNode(1, lNode(1, null, jumps) , jumps) , jumps) , jumps) , jumps) , jumps), jumps), jumps), jumps), jumps) , jumps) , jumps) , jumps);
		System.out.println("<><><><> Before");
		System.out.println(node);
		
		node = jumps.solve(node);
		System.out.println("<>><><><> After");
		System.out.println(node);
	}
}
