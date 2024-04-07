package cc.gaurav.list;

public class ReverseLinkedList {
	class LLNode {
		int val;
		LLNode next;
		
		@Override
		public String toString() {
			return this.val + ", " + (this.next == null ? "" : this.next.toString());
		}
	}
	
	public LLNode solve(LLNode node) {
		LLNode current = node;
		LLNode previous = null;
		LLNode next = node;
		
		while(current != null) {
			current = current.next;
			next.next = null;
			next.next = previous;
			previous = next;
			next = current;
		}
		
		return previous;
	}
	
	private LLNode node(int val, LLNode next) {
		LLNode node = new LLNode();
		node.val = val;
		node.next = next;
		return node;
	}
	
	public static void main(String[] args) {
		ReverseLinkedList r = new ReverseLinkedList();
		//LLNode node = r.node(1, r.node(2, r.node(3, r.node(4, r.node(5, r.node(6, null))))));
		LLNode node = r.node(1, null);
		System.out.println(r.solve(node));
	}
}
