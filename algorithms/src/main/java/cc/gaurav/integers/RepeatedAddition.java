package cc.gaurav.integers;

public class RepeatedAddition {
	public int solve(int n) {
        int result = n;
        do {
            result = reduce(result);
        } while(len(result) != 1);
        
        return result;
    }
    
    public int reduce(int n) {
        int sum = 0;
        while(n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
    
    public int len(int n) {
        return  (int) (Math.log10(n) + 1);
    }
    
    public static void main(String[] args) {
		RepeatedAddition r = new RepeatedAddition();
		System.out.println(r.solve(8835));
	}
}
