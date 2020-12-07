package dev.codefoundry.matrix;

import java.util.Arrays;

/**
 * 
 * @author Gaurav Rai Mazra
 * {@link https://codefoundry.dev}
 *
 */
public class ExcelSpreadSheet {
	public String[][] solve(String[][] matrix) {
        if (matrix.length == 0) return matrix;
        
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (isFormula(matrix[row][col]) || isPointingToAnotherRow(matrix[row][col].charAt(0))) {
                    matrix[row][col] = compute(matrix, row, col);
                }
            }
        }
        
        return matrix;
    }
    
    private String parseOperand(String[][] matrix, String operand) {
        if (operand.charAt(0) == '-' && isPointingToAnotherRow(operand.charAt(1))) {
            String operandWithOutNeg = operand.substring(1);
            String computed = compute(matrix, rowOf(operandWithOutNeg), colOf(operandWithOutNeg));
            return Integer.toString(Integer.parseInt(computed) * -1);
        } else if (isPointingToAnotherRow(operand.charAt(0))) {
            return compute(matrix, rowOf(operand), colOf(operand));
        } else {
            return operand;
        }
    }
    
    private String calculate(String left, String right, char c) {
        if (c == '+') {
            return Integer.toString(Integer.parseInt(left) + Integer.parseInt(right));
        } else {
            return Integer.toString(Integer.parseInt(left) - Integer.parseInt(right));
        }
    }
    
    
    private String compute(String[][] matrix, int row, int col) {
        String expression = matrix[row][col];
        if (isFormula(expression)) {
            int i = 1;
            StringBuilder left = new StringBuilder();
            i = getOperand(left, expression, i);
            String computedLeft = parseOperand(matrix, left.toString());
            
            //There is no 
            if (i == expression.length()) {
                matrix[row][col] = computedLeft;
                return matrix[row][col];
                
            } else {
                char opr = expression.charAt(i++);
                StringBuilder right = new StringBuilder();
                i = getOperand(right, expression, i);
                String computedRight = parseOperand(matrix, right.toString());
                String computedResult = calculate(computedLeft, computedRight, opr);
                matrix[row][col] = computedResult;
                return matrix[row][col];
            }
        } else if (isPointingToAnotherRow(expression.charAt(0))) {
            matrix[row][col] = compute(matrix, rowOf(expression), colOf(expression));
            return matrix[row][col];
        }else {
            return expression;
        }
    }
    
    private int getOperand(StringBuilder sb, String expression, int i) {
        do {
            sb.append(expression.charAt(i++));
        } while(i < expression.length() && !(expression.charAt(i) == '+' || expression.charAt(i) == '-'));
        return i;
    }
    
    private int rowOf(String expression) {
    	return Integer.parseInt(expression.substring(1)) - 1;
    }
    
    private int colOf(String expression) {
    	return expression.charAt(0) - 'A';
    }
    
    private boolean isPointingToAnotherRow(char c) {
        return c - 'A' >= 0 && c - 'A' <= 25;
    }
    
    private boolean isFormula(String value) {
        return value.charAt(0) == '=';
    }
    
    public static void main(String[] args) {
		System.out.println(Arrays.deepToString(new ExcelSpreadSheet().solve(new String[][] {
			{"B1", "2", "0"},
			{"3", "5", "=A1+A2"}
		})));
	
		System.out.println(Arrays.deepToString(new ExcelSpreadSheet().solve(new String[][] {
			{"B1", "-2", "=6+0"},
			{"1", "=A3+A3", "=A2-A1"},
		    {"=-2+B1", "=C1+10", "C2"}
		})));
		
		System.out.println(Arrays.deepToString(new ExcelSpreadSheet().solve(new String[][] {
			{"1", "-2", "=-6+0"},
			{"1", "=-A1", "=-A2-A1"},
		    {"=-2+B1", "=C1+10", "C2"}
		})));
	}
}
