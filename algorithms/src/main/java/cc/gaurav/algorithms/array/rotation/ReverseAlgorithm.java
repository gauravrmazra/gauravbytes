package cc.gaurav.algorithms.array.rotation;

/**
 * 
 * @author Gaurav Rai Mazra
 *
 */
public class ReverseAlgorithm implements ArrayRotation {
	@Override
	public int[] rotate(int[] arr, int distance, int length) {
		rotateLeft(arr, 0, distance - 1);
		rotateLeft(arr, distance, length - 1);
		rotateLeft(arr, 0, length - 1);
		return arr;
	}
	
	private void rotateLeft(int[] arr, int fromIndex, int toIndex) {
		int temp;
		while(fromIndex < toIndex) {
			temp = arr[fromIndex];
			arr[fromIndex] = arr[toIndex];
			arr[toIndex] = temp;
			fromIndex++;
			toIndex--;
		}
	}
}