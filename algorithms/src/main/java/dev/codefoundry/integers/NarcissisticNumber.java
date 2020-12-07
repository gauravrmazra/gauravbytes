package dev.codefoundry.integers;

public class NarcissisticNumber {
	public boolean solve(int n) {
		int number = n;
        int noOfDigits = digits(number);
        int sum = 0;
        while(number != 0) {
            sum += (int)Math.pow(number % 10, noOfDigits);
            number /= 10;
            
            if (sum > n) return false;
        }
        
        return sum == n;
    }
    
    private int digits(int n) {
        return (int) (Math.log10(n) + 1);

    }
    
    public static void main(String[] args) {
		System.out.println(new NarcissisticNumber().solve(153));
	}
}
