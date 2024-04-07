package cc.gaurav.sort;

import java.util.Arrays;

public class SortBinaryArray {
	public int[] solve(int[] a) {
		int i = 0;
		int j = a.length - 1;
		while(i < j) {
			if (a[i] == 1) {
				a[i] = a[j];
				a[j] = 1;
				j--;
			} else {
				i++;
			}
		}
		
		return a;
	}
	
	public static void main(String[] args) {
		SortBinaryArray bn = new SortBinaryArray();
		System.out.println(Arrays.toString(bn.solve(new int[] { 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 
                1, 1, 1, 0, 0, 1, 1, 0, 1, 0, 0 })));
	}
}
