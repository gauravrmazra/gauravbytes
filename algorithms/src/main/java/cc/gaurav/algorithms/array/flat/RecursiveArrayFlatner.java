package cc.gaurav.algorithms.array.flat;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 
 * @author Gaurav Rai Mazra
 * {@linkplain https://gaurav.cc}
 *
 */
public class RecursiveArrayFlatner implements ArrayFlatner<Object> {

	@Override
	public Object[] flat(Object[] elements) {
		if (Objects.isNull(elements)) return elements;
		
		List<Object> flattened = new ArrayList<>(elements.length);
		flat(elements, flattened);
		return flattened.toArray();
	}

	private void flat(Object[] elements, List<Object> flattened) {
		for (Object element : elements)
		{
			if (Objects.nonNull(element) && element.getClass().isArray())
			{
				flat((Object[])element, flattened);
			}
			else
			{
				flattened.add(element);
			}
		}
	}

}
