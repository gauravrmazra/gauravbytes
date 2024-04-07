package cc.gaurav.heap;

import java.util.Arrays;

/**
 * 
 * @author Gaurav Rai Mazra
 * {@link https://gaurav.cc}
 * Implementation of Maximum Heap
 */
public class MaxHeap {
	private static final int DEFAULT_SIZE = 16;
	private int[] elements = new int[DEFAULT_SIZE];
	private int index = 0;

	// Heap properties
	// parent at i (i = 1)
	// left child at (2 * i)
	// right child at ( 2 * i + 1)
	public MaxHeap() {
	}

	public MaxHeap(int[] unsorted) {
		buildMaxHeap(unsorted);
	}

	private void buildMaxHeap(int[] unsorted) {
		for (int element : unsorted) {
			add(element);
		}
	}

	public void add(int element) {
		if (shouldGrow()) {
			grow();
		}

		this.elements[this.index++] = element;
		balanceHeapAfterAddition(elements, this.index - 1);
	}

	private void balanceHeapAfterAddition(int[] elements, int i) {
		if (i >= 1 && elements[i / 2] < elements[i]) {
			int temp = elements[i / 2];
			elements[i / 2] = elements[i];
			elements[i] = temp;

			balanceHeapAfterAddition(elements, i / 2);
		}
	}

	private void grow() {
		this.elements = Arrays.copyOf(this.elements, this.elements.length * 2);
	}

	private boolean shouldGrow() {
		return this.index == elements.length;
	}

	public int max() {
		return this.elements[0];
	}

	public int popMax() {
		int max = this.max();
		this.index--;
		this.elements[0] = this.elements[this.index];
		this.elements[this.index] = -1;

		balanceAfterPopMax(1);
		return max;
	}

	private void balanceAfterPopMax(int index) {
		int left = 2 * index - 1;
		int right = 2 * index;
		int parent = index - 1;
		if (this.elements[left] > this.elements[parent] || this.elements[right] > this.elements[parent]) {

			int replacingIndex = this.elements[left] > this.elements[right] ? left : right;

			int temp = this.elements[parent];
			this.elements[parent] = this.elements[replacingIndex];
			this.elements[replacingIndex] = temp;
			balanceAfterPopMax(replacingIndex + 1);
		}
	}

	public static void main(String[] args) {
		MaxHeap h = new MaxHeap();
		h.add(10);
		h.add(2);
		h.add(5);
		h.add(20);
		h.add(1);
		h.popMax();
		h.add(11);
		System.out.println();
	}
}
