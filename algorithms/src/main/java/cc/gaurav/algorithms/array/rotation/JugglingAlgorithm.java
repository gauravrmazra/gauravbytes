package cc.gaurav.algorithms.array.rotation;

/**
 * 
 * @author Gaurav Rai Mazra
 *
 */
public class JugglingAlgorithm implements ArrayRotation {
	@Override
	public int[] rotate(int[] arr, int distance, int length) {
		int temp, currentElementIndex, elementIndexToMove;
		for (int i = 0; i < gcd(distance, length); i++) {
			temp = arr[i];
			currentElementIndex = i;
			while (true) {
				elementIndexToMove = currentElementIndex + distance;
				
				if (elementIndexToMove >= length)
					elementIndexToMove = elementIndexToMove - length;
				
				if (elementIndexToMove == i) break;
				arr[currentElementIndex] = arr[elementIndexToMove];
				
				currentElementIndex = elementIndexToMove;
			}
			arr[currentElementIndex] = temp;
		}
		return arr;
	}
	
	private int gcd(int a, int b) {
		if (b == 0)
            return a;
        else
            return gcd(b, a % b);
	}
}