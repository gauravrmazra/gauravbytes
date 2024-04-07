package cc.gaurav.string;

/**
 * 
 * @author Gaurav Rai Mazra
 * {@link https://www.gaurav.cc}
 * 
 * Given a positive integer n representing the amount of cents you have, 
 * return the formatted currency amount. 
 * For example, given n = 100000, return "1,000.00".
 *
 */
public class NumberToCurrencyFormatting {
	public String solve(int n) {
		int noOfDigits = (int) (Math.log10(n) + 1);
		
		if (n == 0 || noOfDigits == 1) {
			return "0.0" + n;
		}
		
		if (noOfDigits == 2) {
			return "0." + n;
		}
		
		String result = "";
		int number = n;
		for (int i = 1; i <= noOfDigits; i++) {
			result = number % 10 + result;
			
			if (i == 2) {
				result = "." + result;
			}
			
			if ((i - 2) % 3 == 0 && result.length() != 3 && i != noOfDigits) {
				result = "," + result;
			}
			number = number / 10;
		}
		
		return result;
	}
	
	
	public static void main(String[] args) {
		System.out.println(new NumberToCurrencyFormatting().solve(11));
	}
}
