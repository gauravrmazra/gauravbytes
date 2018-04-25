package com.gauravbytes.algorithms.array.flat;

import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * 
 * @author Gaurav Rai Mazra
 * {@linkplain https://www.lineofcode.in}
 * {@linkplain https://gauravbytes.com}
 *
 */
public class IterativeArrayFlatner implements ArrayFlatner<Object> {

	@Override
	public Object[] flat(Object[] elements) {
		if (Objects.isNull(elements))
			return elements;

		List<Object> flattened = new ArrayList<>(elements.length);
		flat(elements, flattened);
		return flattened.toArray();
	}

	static class ArrayHolder implements Iterator<Object> {
		private final Object[] elements;
		private int index = -1;

		public ArrayHolder(final Object[] elements) {
			this.elements = elements;
		}

		@Override
		public boolean hasNext() {
			return Objects.nonNull(elements) && ++index < elements.length;
		}

		@Override
		public Object next() {
			if (Objects.isNull(elements) || (index == -1 || index > elements.length))
				throw new NoSuchElementException();

			return elements[index];
		}
	}

	
	private static boolean hasNext(ArrayHolder current) {
		return Objects.nonNull(current) && current.hasNext();
	}
	private void flat(Object[] elements, List<Object> flattened) {
		Deque<ArrayHolder> stack = new LinkedList<>();
		stack.push(new ArrayHolder(elements));

		ArrayHolder current = null;
		while (hasNext(current)
				|| (!stack.isEmpty() && hasNext(current = stack.pop()))) {
			Object element = current.next();

			if (Objects.nonNull(element) && element.getClass().isArray()) {
				Object[] e = (Object[]) element;
				stack.push(current);
				stack.push(new ArrayHolder(e));
				current = null;
			} else {
				flattened.add(element);
			}
		}

	}

}
