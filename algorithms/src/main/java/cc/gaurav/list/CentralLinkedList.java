package cc.gaurav.list;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Gaurav Rai Mazra
 * {@link https://www.gaurav.cc}
 * 
 * Return the centre value from the LinkedList
 *
 */
public class CentralLinkedList {
	class LLNode {
		int val;
		LLNode next;
	}
	
	//First Solution
	// Time Complexity O(N)
	// Space Complexity O(N)
	public int solve(LLNode node) {
		List<Integer> values = new ArrayList<>();
		LLNode current = node;
		while(current != null) {
			values.add(current.val);
			current = current.next;
		}
		
		return values.get(values.size() / 2);
	}
	
	//Second Solution
	// Time Complexity O(N)
	// Space Complexity O(1)
	public int solve2(LLNode node) {
		LLNode slow = node;
		LLNode fast = node;
		
		while(slow != null && fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		
		return node == null ? -1 : slow.val;
	}
	
	public LLNode node(int val, LLNode next) {
		LLNode node = new LLNode();
		node.val = val;
		node.next = next;
		return node;
	}
	
	public static void main(String[] args) {
		
		CentralLinkedList central = new CentralLinkedList();
		LLNode oddNode = central.node(5, central.node(2, central.node(3, null)));
		System.out.println("Odd Node centre: " + central.solve(oddNode));
		LLNode evenNode = central.node(5, central.node(2, central.node(3, central.node(6, null))));
		System.out.println("Even Node centre: " + central.solve(evenNode));
		
		
		
	}
}
