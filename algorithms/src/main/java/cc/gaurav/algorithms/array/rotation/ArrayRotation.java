package cc.gaurav.algorithms.array.rotation;

/**
 * 
 * @author Gaurav Rai Mazra
 *
 */
public interface ArrayRotation {
	public default int[] rotate(int[] arr, int distance) {
		return rotate(arr, distance, arr.length);
	}

	public int[] rotate(int[] arr, int distance, int length);
}
