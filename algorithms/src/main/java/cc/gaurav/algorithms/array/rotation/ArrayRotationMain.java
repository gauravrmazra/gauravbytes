package cc.gaurav.algorithms.array.rotation;

import static java.lang.String.format;

import java.util.Arrays;

/**
 * 
 * @author Gaurav Rai Mazra
 *
 */
public class ArrayRotationMain {
	public static void main(String[] args) {
		arrayRotationWithSpaceComplexity();
		
		arrayRotationWithTimeComplexity();
		
		arrayRotationWithJugglingAlgorithm();
		
		arrayRotationWithReversalAlgorithm();
	}

	private static void arrayRotationWithJugglingAlgorithm() {
		System.out.println("Juggling algorithm");
		int[] arrayToRotate = {1, 5, 6, 7, 8, 2, 3, 4};
		JugglingAlgorithm jugglingAlgo = new JugglingAlgorithm();
		System.out.println(format("Before rotation: %s", Arrays.toString(arrayToRotate)));
		int[] rotated = jugglingAlgo.rotate(arrayToRotate, 1, arrayToRotate.length);
		System.out.println(format("After rotation: %s", Arrays.toString(rotated)));
	}
	
	private static void arrayRotationWithReversalAlgorithm() {
		System.out.println("Reversal algorithm");
		int[] arrayToRotate = {1, 5, 6, 7, 8, 2, 3, 4};
		ReverseAlgorithm reversalAlgo = new ReverseAlgorithm();
		System.out.println(format("Before rotation: %s", Arrays.toString(arrayToRotate)));
		int[] rotated = reversalAlgo.rotate(arrayToRotate, 4, arrayToRotate.length);
		System.out.println(format("After rotation: %s", Arrays.toString(rotated)));
	}

	private static void arrayRotationWithTimeComplexity() {
		System.out.println("Time complexity but O(1) space complexity");
		int[] arrayToRotate = {1, 5, 6, 7, 8, 2, 3, 4};
		TimeComplexityNoSpaceComplexity arrayRotation = new TimeComplexityNoSpaceComplexity();
		System.out.println(format("Before rotation: %s", Arrays.toString(arrayToRotate)));
		int[] rotated = arrayRotation.rotate(arrayToRotate, 2, arrayToRotate.length);
		System.out.println(format("After rotation: %s", Arrays.toString(rotated)));
	}

	private static void arrayRotationWithSpaceComplexity() {
		SpaceComplexityAlgorithm arrayRotationWithSpaceComplexity = new SpaceComplexityAlgorithm();
		int[] arrayToRotate = {1, 5, 6, 7, 8, 2, 3, 4};
		System.out.println("Time and space complexity");
		System.out.println(format("Before rotation: %s", Arrays.toString(arrayToRotate)));
		int[] rotated = arrayRotationWithSpaceComplexity.rotate(arrayToRotate, 2, arrayToRotate.length);
		System.out.println(format("After rotation: %s", Arrays.toString(rotated)));
	}
}
