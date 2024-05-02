package cc.gaurav.algorithms.array.flat;

import java.util.Arrays;

/**
 * 
 * @author Gaurav Rai Mazra
 * {@linkplain https://gaurav.cc}
 *
 */
public class ArrayFlatnerMain {
	public static void main(String[] args) {
		ArrayFlatner<Object> recursive = new RecursiveArrayFlatner();
		Object[] flattened = recursive.flat(new Object[] {1, 2, 3, new Object[] {5, 6, 7}, new Object[] {5}, new Object[] {8}});
		System.out.println(Arrays.toString(flattened));
		
		ArrayFlatner<Object> iterative = new IterativeArrayFlatner();
		Object[] iterativeFlattened = iterative.flat(new Object[] {1, 2, 3, new Object[] {5, 6, 7}, new Object[] {5}, new Object[] {8}});
		System.out.println(Arrays.toString(iterativeFlattened));
	}
}
