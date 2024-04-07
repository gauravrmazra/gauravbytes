package cc.gaurav.algorithms.search;

import java.util.logging.Logger;

/**
 * 
 * @author Gaurav Rai Mazra
 *
 */
public class ArraySearch {
	private static final Logger logger = Logger.getLogger("ArraySearch");

	public static void main(String[] args) {
		int[] arr = { 1, 1, 2, 3, 4, 5, 10, 12, 15, 19, 20, 25, 25, 26, 29, 50, 56, 78, 80 };
		int elementToSearch = 25;

		logger.info(() -> String.format("JumpSearch ::>> Element found at index: %d",
				new JumpSearch().search(arr, elementToSearch)));

		logger.info(() -> String.format("FrontAndBackSearch ::>> Element found at index: %d",
				new FrontAndBackSearch().search(arr, elementToSearch)));

		logger.info(() -> String.format("BinarySearch ::>> Element found at index: %d",
				new BinarySearch().search(arr, elementToSearch)));

		logger.info(() -> String.format("NonRecursiveBinarySearch ::>> Element found at index: %d",
				new NonRecursiveBinarySearch().search(arr, elementToSearch)));

		logger.info(() -> String.format("InterpolationSearch ::>> Element found at index: %d",
				new InterpolationSearch().search(arr, elementToSearch)));

		logger.info(() -> String.format("NonRecursiveInterpolationSearch ::>> Element found at index: %d",
				new NonRecursiveInterpolationSearch().search(arr, elementToSearch)));

		logger.info(() -> String.format("LinearSearch ::>> Element found at index: %d",
				new LinearSearch().search(arr, elementToSearch)));
		
		logger.info(() -> String.format("ExponentialSearch ::>> Element found at index: %d",
				new ExponentialSearch().search(arr, elementToSearch)));
	}
}
