package cc.gaurav.queue;

import java.util.Deque;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.function.BiFunction;

public class WordMachine {
	public int solve(String[] words) {
		Deque<Integer> stack = new LinkedList<Integer>();
		for (String word : words) {
			if (findOperation(word).apply(word, stack)) continue;
			
			return -1;
		}
		
		return stack.pop();
	}

	private BiFunction<String, Deque<Integer>, Boolean> constantOperation() {
		return (String s, Deque<Integer> stack) -> {
			stack.push(Integer.parseInt(s));
			return true;
		};
	}

	private BiFunction<String, Deque<Integer>, Boolean> findOperation(String s) {
		BiFunction<String, Deque<Integer>, Boolean> operation;
		switch (s) {
		case "+":
			operation = addOperation();
			break;
		case "-":
			operation = subOperation();
			break;
		case "DUP":
			operation = dupOperation();
			break;
		case "POP":
			operation = popOperation();
			break;
		default:
			operation = constantOperation();
			break;
		}

		return operation;
	}

	private BiFunction<String, Deque<Integer>, Boolean> dupOperation() {
		return (String s, Deque<Integer> stack) -> {
			Integer topElement = stack.peek();
			if (topElement == null) {
				return false;
			} else {
				stack.push(topElement);
				return true;
			}
		};
	}
	
	private BiFunction<String, Deque<Integer>, Boolean> popOperation() {
		return (String s, Deque<Integer> stack) -> {
			try {
				stack.pop();
				return true;

			} catch (NoSuchElementException ex) {
				return false;
			}

		};
	}

	private BiFunction<String, Deque<Integer>, Boolean> addOperation() {
		return (String s, Deque<Integer> stack) -> {
			try {
				Integer leftOperand = stack.pop();
				Integer rightOperand = stack.pop();
				stack.push(leftOperand + rightOperand);
				return true;

			} catch (NoSuchElementException ex) {
				return false;
			}

		};
	}

	private BiFunction<String, Deque<Integer>, Boolean> subOperation() {
		return (String s, Deque<Integer> stack) -> {
			try {
				Integer leftOperand = stack.pop();
				Integer rightOperand = stack.pop();
				stack.push(leftOperand - rightOperand);
				return true;

			} catch (NoSuchElementException ex) {
				return false;
			}

		};
	}

}
