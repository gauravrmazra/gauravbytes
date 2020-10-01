package dev.codefoundry.list;

import java.util.Arrays;

/**
 * 
 * @author Gaurav Rai Mazra
 * {@link https://www.codefoundry.dev}
 *  Create a MinimumStack with following method and
 *  their time complexity should be O(1)
 *  append(int val)
 *  peek()
 *  min()
 *  pop()
 *  
 *  Assume there will be elements in the stack when
 *  these methods will be called.
 */
class MinimumStack {
	private static final int DEFAULT_SIZE = 10;
    private int[] stack;
    private int[] minValueIndex;
    private int mIndex;
    private int index;
    public MinimumStack() {
        this.stack = new int[DEFAULT_SIZE];
        this.minValueIndex = new int[DEFAULT_SIZE];
        this.index = 0;
        this.mIndex = 0;
    }

    public void append(int val) {
        if (stackFull()) {
        	grow();
        }
        this.stack[index++] = val;
        
        int currentMinIndex = mIndex == 0 ? 0 : this.minValueIndex[mIndex - 1];
        int valueAtCurrentMinIndex = this.stack[currentMinIndex];
        this.minValueIndex[mIndex++] = valueAtCurrentMinIndex < val ? currentMinIndex : index - 1; 
    }
    
    private boolean stackFull() {
    	return this.index == this.stack.length - 1;
    }
    
    private void grow() {
    	int[] newStack = Arrays.copyOf(this.stack, this.stack.length * 2);
    	this.stack = newStack;
    	
    	int[] newMinValueIndex = Arrays.copyOf(this.minValueIndex, this.minValueIndex.length * 2);
    	this.minValueIndex = newMinValueIndex;
    }

    public int peek() {
        return this.stack[index - 1];
    }

    public int min() {
        return this.mIndex == 0 ? this.stack[mIndex] : this.stack[this.minValueIndex[this.mIndex - 1]];
    }

    public int pop() {
    	int pop = this.stack[--index];
    	this.minValueIndex[--mIndex] = 0;
    	this.stack[index] = 0;
        return pop;
    }
}
