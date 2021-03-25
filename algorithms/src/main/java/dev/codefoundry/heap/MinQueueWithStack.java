package dev.codefoundry.heap;

import java.util.LinkedList;

public class MinQueueWithStack {
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
	
	LinkedList<Pair> s0 = new LinkedList<>();
	LinkedList<Pair> s1 = new LinkedList<>();
	
	public int min() {
		int min;
		if (s0.isEmpty() || s1.isEmpty()) {
			min = s0.isEmpty() ? s0.peek().min : s1.peek().min; 
		} else {
			min = Math.min(s0.peek().min, s1.peek().min);
		}
		
		return min;
	}
	
	public int remove() {
		if (s1.isEmpty()) {
			while(!s0.isEmpty()) {
				int value = s0.poll().value;
				int min = s1.isEmpty() ? value : Math.min(value, s1.peek().min);
				s1.push(new Pair(value, min));
			}
		}
		
		return s1.poll().value;
	}
	
	public void add(int value) {
		int min = s0.isEmpty() ? value : Math.min(value, s0.peek().min);
		s0.push(new Pair(value, min));
	}
}
