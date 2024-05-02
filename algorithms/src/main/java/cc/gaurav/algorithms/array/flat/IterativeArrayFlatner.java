package cc.gaurav.algorithms.array.flat;

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
 * {@linkplain https://gaurav.cc}
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

	static class ArrayIterator implements Iterator<Object> {
		private final Object[] elements;
		private int index = -1;

		public ArrayIterator(final Object[] elements) {
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

	
	private static boolean hasNext(Iterator<Object> current) {
		return Objects.nonNull(current) && current.hasNext();
	}
	
	private void flat(Object[] elements, List<Object> flattened) {
		Deque<Iterator<Object>> stack = new LinkedList<>();
		stack.push(new ArrayIterator(elements));

		Iterator<Object> current = null;
		while (hasNext(current)
				|| (!stack.isEmpty() && hasNext(current = stack.pop()))) {
			Object element = current.next();

			if (Objects.nonNull(element) && element.getClass().isArray()) {
				Object[] e = (Object[]) element;
				stack.push(current);
				stack.push(new ArrayIterator(e));
				current = null;
			} else {
				flattened.add(element);
			}
		}

	}

}
