package dev.codefoundry.set;

import java.util.Arrays;

class Set {
    
	private static final int DEFAULT_SIZE = 100;
	private int[] values = new int[DEFAULT_SIZE];
	private int currentPos = -1;
	
	public Set() {

    }
	
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
		
		if (valueAtPlace == val) {
		    --this.currentPos;
		    return;
		}
		
		this.values[placeToAdd] = val;
		
		while(placeToAdd < newCurrentPos) {
			valueAtPlace += this.values[++placeToAdd];
			this.values[placeToAdd] = valueAtPlace - this.values[placeToAdd];
			valueAtPlace = valueAtPlace - this.values[placeToAdd];
		}
	}
	
	public boolean exists(int val) {
	    int key = this.floorKey(val);
        return key <= this.currentPos && this.values[key] == val;
    }

    public void remove(int val) {
        int key = this.floorKey(val);
        if (key <= this.currentPos && this.values[key] == val) {
            while(key <= this.currentPos - 1) {
                this.values[key] = this.values[key + 1];
                key++;
            }
            this.values[this.currentPos--] = 0;
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
	
	public static void main(String[] args) {
		Set set = new Set();
		set.add(1);
		set.add(3);
		set.add(2);
		set.add(12);
		set.add(211);
		set.add(11112);
		set.add(111112);
		set.add(222);
		set.add(2121);
		//set.add(21212);
		
		set.add(1);
		
		set.remove(1);
		System.out.println(Arrays.toString(set.values));
	}
}
