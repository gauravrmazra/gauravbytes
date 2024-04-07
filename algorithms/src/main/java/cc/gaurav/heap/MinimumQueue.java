package cc.gaurav.heap;

import java.util.Deque;
import java.util.LinkedList;

public class MinimumQueue {
	Deque<Integer> queue = new LinkedList<Integer>();
	
	public void add(int value) {
		while(!queue.isEmpty() && queue.peek() > value) {
			queue.offer(queue.poll());
		}
		queue.addFirst(value);
	}
	
	public int remove() {
		return queue.poll();
	}
	
	public int min() {
		return queue.peek();
	}
}
