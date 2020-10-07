package dev.codefoundry.list;

public class LinkedListDeleteLastOccurance {
	class LLNode {
		int val;
		LLNode next;
	}
	
	public LLNode solve(LLNode node, int target) {
		LLNode toDelete = null;
		
		LLNode previous = null;
		LLNode current = node;
		boolean hasNodeToDelete = false;
		while(current != null) {
			if (current.val == target) {
				hasNodeToDelete = true;
				toDelete = previous;
			}
			previous = current;
			current = current.next;
		}
		
		if (hasNodeToDelete) {
			if (toDelete == null) {
				node = node.next;
			} else {
				previous.next = previous.next.next;
			}
		}
		
		return node;
	}
}
