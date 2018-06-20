package com.gauravbytes.java10.collection;

import java.util.List;

/**
 * 
 * @author Gaurav Rai Mazra <a href="https://gauravbytes.com">Blog - Gaurav
 *         Bytes</a>
 */
public class ImmutableLists {
	public static void main(String[] args) {

		// ImmutableCollections.List0 instance
		List<String> emptyImmutableList = List.of();
		System.out.println(emptyImmutableList.getClass().getName()  + ": " + emptyImmutableList);

		// ImmutableCollections.List1 instance
		List<String> singleElementImmutableList = List.of("Gaurav");
		System.out.println(singleElementImmutableList.getClass().getName()  + ": " + singleElementImmutableList);

		// ImmutableCollections.List2 instance
		List<String> twoElementImmutableList = List.of("Gaurav", "Sachin");
		System.out.println(twoElementImmutableList.getClass().getName()  + ": " + twoElementImmutableList);

		// More than two elements have ImmutableCollections.ListN instance
		List<String> nElementImmutableList = List.of("Gaurav", "Parag", "Sachin");
		System.out.println(nElementImmutableList.getClass().getName()  + ": " + nElementImmutableList);
	}
}
