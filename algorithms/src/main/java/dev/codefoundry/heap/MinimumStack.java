package dev.codefoundry.heap;

import java.util.LinkedList;

/**
 * 
 * @author Gaurav Rai Mazra
 * {@link https://codefoundry.dev}
 *
 */
public class MinimumStack {
	class Pair {
		int value;
		int min;

		public Pair(int value, int min) {
			this.value = value;
			this.min = min;
		}

		@Override
		public String toString() {
			return "[VALUE: " + this.value + ", MIN: " + this.min + "]";
		}
	}

	private LinkedList<Pair> stack = new LinkedList<>();

	public void add(int value) {
		int min = stack.isEmpty() ? value : Math.min(value, stack.peek().min);
		stack.push(new Pair(value, min));
	}
	
	public int remove() {
		return this.stack.pop().value;
	}
	
	public int min() {
		return this.stack.peek().min;
	}
}
