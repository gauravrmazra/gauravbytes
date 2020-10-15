package dev.codefoundry.queue;

import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowAverage {
	long running = 0l;
	private int windowSize;
	private Deque<Integer> q = new LinkedList<Integer>();
	public SlidingWindowAverage(int window_size) {
		this.windowSize = window_size;

    }

    public double average(int val) {
        if (this.q.size() == this.windowSize) {
        	int removed = q.removeFirst();
        	this.running -= removed;
        }
        
        this.q.addLast(val);
        
        this.running = this.running + val;
        
        return this.running / this.windowSize;
    }
    
    public static void main(String[] args) {
		System.out.println('a' - 0);
		System.out.println('b' - 0);
		System.out.println('A' - 0);
		System.out.println('B' - 0);
	}
}
