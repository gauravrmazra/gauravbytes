package dev.codefoundry.string;

import java.util.LinkedList;

/**
 * 
 * @author Gaurav Rai Mazra
 * {@link https://codefoundry.dev}
 *
 */
public class DecodeString {
	String readStringToRepeat(LinkedList<String> stack) {
        String s = "";
        while(!stack.peek().equals("[")) {
            s = stack.pop() + s;   
        }
        
        stack.pop(); // pop [ bracket
        
        
        return s; 
    }
    
    int timesStringToRepeat(LinkedList<String> stack) {
        StringBuilder digit = new StringBuilder();
        while(stack.peek() != null && Character.isDigit(stack.peek().charAt(0))) {
            digit.append(stack.pop());
        }

        return Integer.valueOf(digit.reverse().toString());
    }
    
    public String decodeString(String s) {
        LinkedList<String> stack = new LinkedList<>();
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ']') {
                String stringToRepeat = readStringToRepeat(stack);
                int times = timesStringToRepeat(stack);
                stack.push(stringToRepeat.repeat(times));
                
            } else {
                stack.push(s.charAt(i) + "");
            }
        }
        
        String returnValue = "";
        
        while(stack.isEmpty() == false) {
        	s = stack.pop() + s;
        }
        
        return returnValue;
    }
    
    public static void main(String[] args) {
		DecodeString ds = new DecodeString();
		System.out.println(ds.decodeString("3[a]2[bc]"));
	}

}
