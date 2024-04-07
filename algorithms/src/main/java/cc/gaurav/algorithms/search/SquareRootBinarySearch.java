package cc.gaurav.algorithms.search;

import java.math.BigInteger;

/**
 * 
 * @author Gaurav Rai Mazra
 * {@link https://www.gaurav.cc}
 * 
 * Find square root using Binary Search
 *
 */
public class SquareRootBinarySearch {
	public int solve(int n) {
		int low = 0;
        int high = n;
        BigInteger number = BigInteger.valueOf(n);
        
        int mid;
        while (low < high) {
            mid = low + (high - low) / 2;
            
            BigInteger midVal = BigInteger.valueOf(mid);
            BigInteger midProduct = midVal.multiply(midVal);
            if (midProduct.compareTo(number) <= 0) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low - 1;
	}
	
	public static void main(String[] args) {
		System.out.println(new SquareRootBinarySearch().solve(29194285));
	}
}
