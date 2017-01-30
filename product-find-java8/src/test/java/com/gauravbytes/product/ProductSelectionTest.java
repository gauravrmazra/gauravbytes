package com.gauravbytes.product;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Iterator;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class ProductSelectionTest {
	private ProductSearcher productSearcher;
	private ProductCatalog catalog;

	private Product railTrack = new Product("r187", "Rail Track", Color.RED, 3.45d,
	    Size.MEDIUM);

	private Product barbieDoll = new Product("b187", "Barbie Doll", Color.PINK, 7.15d,
	    Size.SMALL);

	private Product monsterTruck = new Product("m187", "Monster Truck", Color.YELLOW, 9.99d,
	    Size.LARGE);

	private Product cricketBat = new Product("b2343", "Cricket Bat", Color.WHITE, 19.25d,
	    Size.NOT_APPLICABLE);

	private Product toyCar = new Product("t187", "Toy Skoda", Color.RED, 125.00d,
	    Size.NOT_APPLICABLE);

	@Before
	public void setUp() {
		productSearcher = new ProductSearcher(createProductCatalog());
	}

	private ProductCatalog createProductCatalog() {
		catalog = new ProductCatalog();
		catalog.add(railTrack);
		catalog.add(barbieDoll);
		catalog.add(monsterTruck);
		catalog.add(cricketBat);
		catalog.add(toyCar);
		return catalog;
	}

	@Test
	public void testFindByID() {
		String pid = "r187";
		List<Product> foundProducts = productSearcher.byID(pid);

		assertEquals(1, foundProducts.size());

		assertTrue(foundProducts.contains(railTrack));
	}

	@Test
	public void testFindBySize() {
		List<Product> foundProducts = productSearcher.bySize(Size.MEDIUM);
		assertEquals(1, foundProducts.size());

		foundProducts = productSearcher.bySize(Size.NOT_APPLICABLE);
		assertEquals(2, foundProducts.size());
	}

	@Test
	public void testFindByColor() {
		List<Product> foundProducts = productSearcher.byColor(Color.RED);
		assertEquals(2, foundProducts.size());

		assertTrue(foundProducts.contains(railTrack));

		assertTrue(foundProducts.contains(toyCar));
	}

	@Test
	public void testFindByPrice() {
		List<Product> foundProducts = productSearcher.byPrice(19.25d);
		assertEquals(1, foundProducts.size());
		for (Iterator<Product> i = foundProducts.iterator(); i.hasNext();) {
			Product p = (Product) i.next();
			assertTrue(p.getPrice() == 19.25d);
		}
	}

	@Test
	public void testFindBelowPrice() {
		List<Product> foundProducts = productSearcher.belowPrice(10.00f);
		assertEquals(3, foundProducts.size());
		for (Iterator<Product> i = foundProducts.iterator(); i.hasNext();) {
			Product p = (Product) i.next();
			assertTrue(p.getPrice() < 10.00d);
		}
	}

	@Test
	public void testFindByColorAndBelowPrice() {
		List<Product> foundProducts = productSearcher.byColorAndBelowPrice(Color.RED, 10.00d);
		assertEquals(1, foundProducts.size());
		assertEquals(railTrack, foundProducts.get(0));
	}

	@Test
	public void testFindByColorSizeAndBelowPrice() {
		List<Product> foundProducts = productSearcher.byColorSizeAndBelowPrice(Color.RED,
		    Size.SMALL, 10.00d);

		assertEquals(0, foundProducts.size());

		foundProducts = productSearcher.byColorSizeAndBelowPrice(Color.RED, Size.MEDIUM,
		    10.00d);

		assertEquals(railTrack, foundProducts.get(0));
	}

	@Test
	public void testFindByColorAndAbovePrice() {
		List<Product> foundProducts = productSearcher.byColorAndAbovePrice(Color.WHITE,
		    25.00d);
		assertEquals(0, foundProducts.size());

		foundProducts = productSearcher.byColorAndAbovePrice(Color.RED, 25.00d);

		assertEquals(toyCar, foundProducts.get(0));
	}

	@Test
	public void testFindBelowPriceAvoidingAColor() {
		List<Product> foundProducts = productSearcher.belowPriceAndNotColor(20.00d,
		    Color.WHITE);
		assertEquals(3, foundProducts.size());
		assertTrue(foundProducts.contains(railTrack));
	}
}
