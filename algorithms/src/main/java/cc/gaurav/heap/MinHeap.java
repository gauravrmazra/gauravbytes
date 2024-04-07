package cc.gaurav.heap;

import java.util.Arrays;

public class MinHeap {
  static class Pair {
    final int idx;
    final String val;
    public Pair(int idx, String val) {
      this.idx = idx;
      this.val = val;
    }

    @Override
    public String toString() {
      return "[ idx: " + idx + ", Value: " + val + " ]";
    }
  }

	private Pair[] elements;
	private int index = 0;
  private int counter = 0;

  public MinHeap(String[] values) {
    elements = new Pair[values.length];
    buildMinHeap(values);
  }

  public void buildMinHeap(String[] values) {
    for (String value : values) {
      add(new Pair(counter++, value));
    }
  }

  public void add(Pair p) {
    this.elements[this.index++] = p;
    balanceHeapAfterAddition(elements, this.index - 1); 
  }

  private void balanceHeapAfterAddition(Pair[] pairs, int idx) {
    if (idx >= 1 && Integer.compare(pairs[idx / 2].idx, pairs[idx].idx) > 0) {
      Pair temp = pairs[idx / 2];
      pairs[idx / 2] = pairs[idx];
      pairs[idx] = temp;
      balanceHeapAfterAddition(pairs, idx / 2);
    }
  }

  public String removeAt(int idx) {
    Pair p = this.elements[idx];
    this.elements[idx] = this.elements[--this.index];
    this.elements[this.index] = null;

    balanceAfterDelete(1);

    add(new Pair(counter++, p.val));
    return p.val;
  }

  private void balanceAfterDelete(int index) {
    int left = 2 * index - 1;
		int right = 2 * index;
		int parent = index - 1;
		if (this.elements[left].idx > this.elements[parent].idx || this.elements[right].idx > this.elements[parent].idx) {

			int replacingIndex = this.elements[left].idx > this.elements[right].idx ? left : right;

			int temp = this.elements[parent].idx;
			this.elements[parent] = this.elements[replacingIndex];
			this.elements[replacingIndex] = new Pair(temp, this.elements[replacingIndex].val);
			balanceAfterDelete(replacingIndex + 1);
    }
  } 


  public static void main(String[] args) {
    MinHeap heap = new MinHeap(new String[] { "d", "a", "c", "b" });
    System.out.println(Arrays.deepToString(heap.elements));
  
  }
}
