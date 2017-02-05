package com.gauravbytes.product;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

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
		List<Product> foundProducts = productSearcher.selectBy(p -> p.getID() == pid);

		assertEquals(1, foundProducts.size());

		assertTrue(foundProducts.contains(railTrack));
	}

	@Test
	public void testFindBySize() {
		Predicate<Product> byMediumSize = p -> p.getSize() == Size.MEDIUM;
		List<Product> foundProducts = productSearcher.selectBy(byMediumSize);
		assertEquals(1, foundProducts.size());

		Predicate<Product> bySizeNotApplicable = p -> p.getSize() == Size.NOT_APPLICABLE;
		foundProducts = productSearcher.selectBy(bySizeNotApplicable);
		assertEquals(2, foundProducts.size());
	}

	@Test
	public void testFindByColor() {
		Predicate<Product> byColor = p -> p.getColor() == Color.RED;
		List<Product> foundProducts = productSearcher.selectBy(byColor);
		assertEquals(2, foundProducts.size());

		assertTrue(foundProducts.contains(railTrack));

		assertTrue(foundProducts.contains(toyCar));
	}

	@Test
	public void testFindByPrice() {
		Predicate<Product> byPrice = p -> p.getPrice() == 19.25d;
		List<Product> foundProducts = productSearcher.selectBy(byPrice);
		assertEquals(1, foundProducts.size());
		for (Iterator<Product> i = foundProducts.iterator(); i.hasNext();) {
			Product p = (Product) i.next();
			assertTrue(p.getPrice() == 19.25d);
		}
	}

	@Test
	public void testFindBelowPrice() {
		Predicate<Product> belowPrice = p -> p.getPrice() < 10.00d;
		List<Product> foundProducts = productSearcher.selectBy(belowPrice);
		assertEquals(3, foundProducts.size());
		for (Iterator<Product> i = foundProducts.iterator(); i.hasNext();) {
			Product p = (Product) i.next();
			assertTrue(p.getPrice() < 10.00d);
		}
	}

	@Test
	public void testFindByColorAndBelowPrice() {
		Predicate<Product> byColor = p -> p.getColor() == Color.RED;
		Predicate<Product> belowPrice = p -> p.getPrice() < 10.00d;

		List<Product> foundProducts = productSearcher.selectBy(byColor.and(belowPrice));
		assertEquals(1, foundProducts.size());
		assertEquals(railTrack, foundProducts.get(0));
	}

	@Test
	public void testFindByColorSizeAndBelowPrice() {
		Predicate<Product> byColor = p -> p.getColor() == Color.RED;
		Predicate<Product> bySize = p -> p.getSize() == Size.SMALL;
		Predicate<Product> belowPrice = p -> p.getPrice() < 10.00d;

		List<Product> foundProducts = productSearcher
		    .selectBy(byColor.and(bySize).and(belowPrice));

		assertEquals(0, foundProducts.size());

		Predicate<Product> byMediumSize = p -> p.getSize() == Size.MEDIUM;

		foundProducts = productSearcher.selectBy(byColor.and(byMediumSize).and(belowPrice));

		assertEquals(railTrack, foundProducts.get(0));
	}

	@Test
	public void testFindByColorAndAbovePrice() {
		Predicate<Product> byColor = p -> p.getColor() == Color.WHITE;
		Predicate<Product> abovePrice = p -> p.getPrice() > 25.00d;
		List<Product> foundProducts = productSearcher.selectBy(byColor.and(abovePrice));
		assertEquals(0, foundProducts.size());

		Predicate<Product> byRedColor = p -> p.getColor() == Color.RED;
		foundProducts = productSearcher.selectBy(byRedColor.and(abovePrice));

		assertEquals(toyCar, foundProducts.get(0));
	}

	@Test
	public void testFindBelowPriceAvoidingAColor() {
		Predicate<Product> belowPrice = p -> p.getPrice() < 20.00d;
		Predicate<Product> notColor = p -> p.getColor() != Color.WHITE;

		List<Product> foundProducts = productSearcher.selectBy(belowPrice.and(notColor));
		assertEquals(3, foundProducts.size());
		assertTrue(foundProducts.contains(railTrack));
	}
}
