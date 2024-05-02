package cc.gaurav.string;

import java.util.ArrayList;
import java.util.List;

public class LazyRunLengthDecodingV1 {
	    List<String> str = new ArrayList<>();
	    private int index = -1;
	    private String s;
	    private int indexToRead = 0;
	    public LazyRunLengthDecodingV1(String s) {
	        this.s = s;
	    }

	    private void parse(String s, int to, int end) {
	    	int i = indexToRead;
	        while(i < s.length() && to <= end) {
	            if(Character.isDigit(s.charAt(i))) {
	                int start = i;
	                while(Character.isDigit(s.charAt(i))) {
	                    i++;
	                }

	                String noAsString = s.substring(start, i);
	                int intz = Integer.parseInt(noAsString);
	                addToList(str, intz, "" + s.charAt(i++));
	                to += intz;
	            }
	            else {
	                to++;
	                addToList(str, 1, "" + s.charAt(i));
	            }
	            this.indexToRead = i;
	        }
	        this.index = this.str.size();
	    }
	    
	    private void addToList(List<String> l, int n, String c) {
	        while(n-- > 0) {
	            l.add(c);
	        }
	    }

	    public String value(int i) {
	        if (index <= i) {
	            parse(this.s, index, i);
	        }
	        
	        return this.str.get(i);
	    }

	    public String valueInRange(String c, int i, int j) {
	        if (index <= j) {
	            parse(this.s, index, j);
	        }

	        return bs(str, c, i, j);
	    }

	    private String bs(List<String> str, String target, int left, int right) {
	        int mid;
	        int rightRange = right;
	        while(left < right) {
	            mid = left + (right - left) / 2;
	            int cmp = str.get(mid).compareTo(target);
	            if (cmp == 0) return target;
	            else if (cmp < 0) {
	                left = mid + 1;
	            } else {
	                right = mid;
	            }
	        }
	        return (left < rightRange && left < str.size() && str.get(left).compareTo(target) >= 0) ? str.get(left) : "?";
	    }
}
