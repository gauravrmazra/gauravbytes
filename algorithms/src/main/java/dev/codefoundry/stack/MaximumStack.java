package dev.codefoundry.stack;

import java.util.Objects;
import java.util.TreeSet;

/**
 * 
 * @author Gaurav Rai Mazra
 * {@link https://codefoundry.dev}
 * 
 * 
 *
 */
public class MaximumStack {
	private TreeSet<Node> max = new TreeSet<>((Node a, Node b) -> {
		int cmp = Integer.compare(b.value, a.value);
		return cmp == 0 ? Integer.compare(b.index, a.index) : cmp;

	});
	
	static class Node {
		int value;
		int index;

		Node next;
		Node prev;

		public Node(int value, int index) {
			this.value = value;
			this.index = index;
		}
		
		@Override
		public boolean equals(Object obj) {
			if (obj == null || !Node.class.isInstance(obj))
				return false;

			Node other = Node.class.cast(obj);

			return this.value == other.value && this.index == other.index;
		}

		@Override
		public int hashCode() {
			return Objects.hash(this.value, this.index);
		}

		@Override
		public String toString() {
			return "[Node: val: " + this.value + ", index: " + this.index + " ]";
		}
	}

	private Node head;
	private Node tail;
	private int size;

	public MaximumStack() {
		this.size = 0;
	}

	public void append(int val) {
		Node n = new Node(val, this.size);
		if (this.size == 0) {
			head = tail = n;
			this.max.add(head);
		} else {
			tail.next = n;
			n.prev = tail;
			tail = n;
			this.max.add(n);
		}

		this.size++;
	}

	public int peek() {
		return this.tail.value;
	}

	public int pop() {
		Node n;
		if (head == tail) {
			n = head;
			head = tail = null;
		} else {
			Node tmp = tail;
			tail = tmp.prev;
			tail.next = null;
			n = tmp;
		}
		this.max.remove(n);

		return n.value;
	}

	public int max() {
		return this.max.first().value;
	}

	public int popmax() {
		Node max = this.max.pollFirst();
		
		Node previousToCurrent = max.prev;
		if (previousToCurrent == null) {
			head = head.next;
			if (head == null) {
				tail = null;
			} else {
				head.prev = null;
			}
		} else {
			previousToCurrent.next = max.next;
			if (previousToCurrent.next != null) {
				previousToCurrent.next.prev = previousToCurrent;
			} else {
				tail = previousToCurrent;
			}
		}

		return max.value;
	}

	public static void main(String[] args) {
		MaximumStack stack = new MaximumStack();
		stack.append(4);
		stack.append(5);
		stack.pop();
		stack.popmax();
	}
}
