package dev.codefoundry.list;

/**
 * Remove all target elements from LinkedList
 * 
 * @author gmazra
 *
 */
public class LinkedListRemoval {
	class LLNode {
		int data;
		LLNode next;

		@Override
		public String toString() {
			return "[data=" + data + ", next:[" + (next != null ? next.toString() : "") + "]]";
		}
	}

	public LLNode solve(LLNode node, int target) {
		LLNode current;
		LLNode previous;

		for (current = previous = node; current != null;) {
			if (current.data == target) {
				if (previous == current) {
					previous = current.next;
					node = previous;
				} else {
					previous.next = current.next;
				}
				current = previous;
				continue;
			}
			previous = current;
			current = current != null ? current.next : null;
		}

		return node;
	}

	// Test function only
	
	static LLNode lNode(int data, LLNode next, LinkedListRemoval b) {
		LLNode node = b.new LLNode();
		node.data = data;
		node.next = next;
		return node;
	}
	
	public static void main(String[] args) {
		LinkedListRemoval llr = new LinkedListRemoval();
		
		LLNode head = lNode(1, lNode(2, lNode(2, lNode(1, null, llr), llr), llr), llr);
		System.out.println("<><><> Before");
		System.out.println(head);
		
		LLNode removed = llr.solve(head, 1);
		
		System.out.println("<><><> After");
		System.out.println(removed);
	}
}
