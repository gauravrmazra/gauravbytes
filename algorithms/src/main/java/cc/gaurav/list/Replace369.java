package cc.gaurav.list;

import java.util.Arrays;

/**
 * 
 * @author Gaurav Rai Mazra
 * {@link https://gaurav.cc}
 * 
 * For any positive number n, generate a series till n and replace all number divisible by 3, 6 and 9 with clap
 * and any digit containing 3, 6 or 9 by clap in the number
 *
 */
public class Replace369 {
	public String[] solve(int n) { // Write your code here
        String[] a = new String[n];
        int number;
        for (int i = 0, j = 0; i < n; i++) {
            number = i + 1;
            j++;
            if (j == 3) {
                a[i] = "clap";
                j = 0;
            } else {
                String temp = String.valueOf(number);
                boolean added = false;
                char c;
                for (int k = 0; k < temp.length(); k++) {
                    c = temp.charAt(k);
                    if (c == '0') {
                        continue;
                    }
                    
                    if (c == '3' || c == '6' || c == '9') {
                        a[i] = "clap";
                        added = true;
                        break;
                    }
                }
                
                
                if (!added) {
                    a[i] = temp; 
                }
            }
        }
        
        return a;
    }

	public static void main(String[] args) {
		Replace369 replace = new Replace369();
		String[] result = replace.solve(31);
		System.out.println(Arrays.deepToString(result));
	}
}

