package dev.codefoundry.list;

public class LinkedListRotation {
	class LLNode {
		int val;
		LLNode next;
		
		@Override
		public String toString() {
			return this.val + ", " + (this.next == null ? "" : this.next.toString());
		}
	}

	public LLNode solve(LLNode node, int k) {
		if (k == 0) {
			return node;
		}

		LLNode current = node;
		LLNode fast = node;
		while (k > 0) {
			k--;
			fast = fast.next;
			if (fast == null) {
				fast = node;
			}
		}
		
		if (fast == current) {
			return fast;
		}
		
		LLNode slow = current;
		LLNode previous = null;
		while (fast != null) {
			fast = fast.next;
			previous = current;
			current = current.next;
		}

		previous.next = null;

		LLNode fakeRoot = new LLNode();
		fakeRoot.next = current;
		while (current != null) {
			previous = current;
			current = current.next;
		}

		previous.next = slow;

		return fakeRoot.next;
	}
	
	private LLNode node(int val, LLNode next) {
		LLNode node = new LLNode();
		node.val = val;
		node.next = next;
		return node;
	}
	
	public static void main(String[] args) {
		LinkedListRotation r = new LinkedListRotation();
		LLNode node = r.node(1, r.node(2, r.node(3, r.node(4, r.node(5, r.node(6, null))))));
		System.out.println(r.solve(node, 6));
	}
}
