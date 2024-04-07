package cc.gaurav.list;

/**
 * 
 * @author Gaurav Rai Mazra
 * {@link https://gaurav.cc}
 * 
 * Reverse the subList from LinkedList
 *
 */
public class ReverseInnerLinkedList {
	class LLNode {
		int val;
		LLNode next;
	
		@Override
		public String toString() {
			return "" + this.val + (this.next != null ? " -> " + this.next.toString() : "");
		}
	}
	
	public LLNode solve(LLNode node, int i, int j) {
		LLNode fakeRoot = new LLNode();
		fakeRoot.next = node;
		
		LLNode ithNode = fakeRoot.next;
		LLNode previousNodeToithNode = fakeRoot;
		
		int m = 0;
		while(m++ < i) {
			previousNodeToithNode = ithNode;
			ithNode = ithNode.next;	
		}
		
		LLNode jthNode = ithNode;
		while(m++ <= j) {
			jthNode = jthNode.next;
		}
		
		LLNode nextNodeToJthNode = jthNode.next;
		
		LLNode reversed = reverse(ithNode, nextNodeToJthNode);
		
		previousNodeToithNode.next = reversed;
		
		return fakeRoot.next;
	}


	private LLNode reverse(LLNode ithNode, LLNode nextNodeToJthNode) {
		LLNode previous = nextNodeToJthNode;
		LLNode current = ithNode;
		LLNode following = ithNode;
		while(current != nextNodeToJthNode) {
			following = following.next;
			current.next = previous;
			previous = current;
			current = following;
		}
		return previous;
	}
	

	private LLNode node(int val, LLNode next) {
		LLNode n = new LLNode();
		n.val = val;
		n.next = next;
		return n;
	}
	
	public static void main(String[] args) {
		ReverseInnerLinkedList list = new ReverseInnerLinkedList();
		//0 -> 1-> 2 -> 3 -> 4
		LLNode head = list.node(0, list.node(1, list.node(2, list.node(3, list.node(4, null)))));
		
		System.out.println(list.solve(head, 0, 1));
	}
}
