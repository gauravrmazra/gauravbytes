package cc.gaurav.list;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 
 * @author Gaurav Rai Mazra
 * {@link https://gaurav.cc}
 * 
 * Remove the Kth Element from the last from SinglyLinkedList
 *
 */
public class LinkedListDeleteKthElement {
	static class DeleteHeadElementException extends RuntimeException {
		private static final long serialVersionUID = -1369041924544222495L;
	}

	static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
			this.next = null;
		}

		@Override
		public String toString() {
			return "[data=" + this.data + "], next: [" + (this.next != null ? this.next.toString() : "NULL") + "]";
		}
	}

	private Node head;

	void add(int data) {
		Node h = this.head;
		if (h == null) {
			h = new Node(data);
			this.head = h;
			return;
		}

		Node current = h;
		while (current.next != null)
			current = current.next;

		current.next = new Node(data);
	}

	void deleteKthElementFromLast(int index) {
		Node first;
		Node second;
		first = second = this.head;

		for (int i = 0; i < index; i++) {
			if (second.next == null) {
				if (i == index - 1) {
					this.head = this.head.next;
				}
				return;
			}
			second = second.next;
		}

		while (second.next != null) {
			first = first.next;
			second = second.next;
		}

		first.next = first.next.next;
	}

	void deleteKthElementFromLastRecursive(int index) {
		Node head = this.head;
		AtomicBoolean b = new AtomicBoolean(false);
		AtomicInteger i = new AtomicInteger(index);

		try {
			deleteKthElement(head, head, i, b);
		} catch (DeleteHeadElementException ex) {
			this.head = this.head.next;
		}

	}

	void deleteKthElement(Node head, Node current, AtomicInteger index, AtomicBoolean startReducingIndex) {

		if (current.next == null) {
			startReducingIndex.set(true);
		}

		if (current.next != null) {
			deleteKthElement(current, current.next, index, startReducingIndex);
		}

		if (startReducingIndex.get()) {
			int value = index.decrementAndGet();
			if (value == 0 && head == current) {
				throw new DeleteHeadElementException();
			}

			if (value == -1) {
				current.next = current.next.next;
			}
		}
	}

	@Override
	public String toString() {
		return this.head.toString();
	}

	// Test functions
	public static void main(String[] args) {
		LinkedListDeleteKthElement l = new LinkedListDeleteKthElement();

		l.add(10);
		l.add(20);
		l.add(100);
		l.add(70);
		l.add(200);
		l.add(500);

		System.out.println(l);

		l.deleteKthElementFromLast(7);

		System.out.println(l);
		System.out.println("<><><><><><><><><>");
		LinkedListDeleteKthElement l1 = new LinkedListDeleteKthElement();

		l1.add(10);
		l1.add(20);
		l1.add(100);
		l1.add(70);
		l1.add(200);
		l1.add(500);

		System.out.println(l1);

		l1.deleteKthElementFromLastRecursive(7);

		System.out.println(l1);
	}
}
