package dev.codefoundry.list;

import java.util.Arrays;

/**
 * Two sum solution
 * @author Gaurav Rai Mazra
 * {@link https://www.codefoundry.dev}
 *
 */
public class TwoSumV2 {
	private static final int DEFAULT_SIZE = 10;
	private int[] values = new int[DEFAULT_SIZE];
	private int currentPos = -1;
	
	public void add(int val) {
		if(shouldGrow()) {
			grow();
		}
		
		int newCurrentPos = ++this.currentPos;
		int placeToAdd = floorKey(val);
		
		if (placeToAdd == newCurrentPos) {
			this.values[placeToAdd] = val;
			return;
		}
		
		int valueAtPlace = this.values[placeToAdd];
		
		this.values[placeToAdd] = val;
		
		while(placeToAdd < newCurrentPos) {
			valueAtPlace += this.values[++placeToAdd];
			this.values[placeToAdd] = valueAtPlace - this.values[placeToAdd];
			valueAtPlace = valueAtPlace - this.values[placeToAdd];
		}
	}
	
	private int floorKey(int key) {
		int low = 0;
		int hi = this.currentPos;
		
		int mid;
		while(low < hi) {
			mid = low + (hi - low) / 2;
			
			if (values[mid] == key) {
				return mid;
			} else if (values[mid] > key) {
				hi = mid;
			} else {
				low = mid + 1;
			}
		}
		
		return low;
	}
	
	private boolean shouldGrow() {
		return this.currentPos == this.values.length - 1;
	}
	
	private void grow() {
		this.values = Arrays.copyOf(this.values, this.values.length * 2);
	}
	
	private boolean isEmpty() {
		return this.currentPos == -1;
	}
	
	private int size() {
		return this.currentPos + 1;
	}
 	
	public boolean find(int val) {
		if (isEmpty() || size() == 1) return false;
		
		int start = 0;
		int end = this.currentPos; 
		
		int sum;
		while(start < end) {
			sum = this.values[start] + this.values[end];
			if (sum == val) {
				return true;
			} else if (sum > val) {
				end--;
			} else {
				start++;
			}
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		TwoSumV2 v2 = new TwoSumV2();
		v2.add(5);
		System.out.println(v2.find(10));
		v2.add(6);
		System.out.println(v2.find(11));
	}
}
