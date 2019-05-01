package com.gauravbytes.java8.customcollector;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;


/**
 * 
 * @author Gaurav Rai Mazra <a href="https://grai.dev">Gaurav's Portfolio</a>
 *         <a href="https://www.gauravbytes.com">Gaurav's Blog</a>
 */
public class CustomCollectorExample {
	static enum Season {
		WINTER, SUMMER, AUTUMN, SPRING;
	}
	
	static class Fruit {
		private String name;
		private double price;
		private Season season;
		
		Fruit(String name, double price, Season season) {
			this.name = name;
			this.price = price;
			this.season = season;
		}
		
		public String getName() {
			return name;
		}

		public double getPrice() {
			return price;
		}

		public Season getSeason() {
			return season;
		}

		@Override
		public String toString() {
			return "Fruit [name=" + name + ", price=" + price + ", season=" + season + "]";
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((name == null) ? 0 : name.hashCode());
			long temp;
			temp = Double.doubleToLongBits(price);
			result = prime * result + (int) (temp ^ (temp >>> 32));
			result = prime * result + ((season == null) ? 0 : season.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Fruit other = (Fruit) obj;
			if (name == null) {
				if (other.name != null)
					return false;
			} else if (!name.equals(other.name))
				return false;
			if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
				return false;
			if (season != other.season)
				return false;
			return true;
		}
	}
	
	public static void main(String[] args) {
		List<Fruit> fruits = Arrays.asList(new Fruit("Banana", 1.3d, Season.WINTER),
				new Fruit("Banana", 1.7d, Season.WINTER), new Fruit("Banana", 1.3d, Season.WINTER),
				new Fruit("Banana", 1.6d, Season.WINTER), new Fruit("Banana", 1.1d, Season.WINTER),
				new Fruit("Banana", 1.3d, Season.SUMMER), new Fruit("Banana", 1.7d, Season.SUMMER),
				new Fruit("Banana", 1.3d, Season.SPRING), new Fruit("Banana", 1.6d, Season.SUMMER),
				new Fruit("Banana", 1.1d, Season.SUMMER));

		EnumMap<Season, Map<String, BigDecimal>> groupBySeasonWithAveragePricePerFruit = fruits.stream()
				.collect(groupBySeasonWithAveragePricePerFruit());

		groupBySeasonWithAveragePricePerFruit.forEach((k, v) -> {
			System.out.print(k);
			System.out.print('\t');
			System.out.print(v);
			System.out.println();
		});
	}
	
	private static Collector<Fruit, EnumMap<Season, Map<String, List<Fruit>>>, EnumMap<Season, Map<String, BigDecimal>>> groupBySeasonWithAveragePricePerFruit() {
		Supplier<EnumMap<Season, Map<String, List<Fruit>>>> supplier = () -> new EnumMap<>(Season.class);

		BiConsumer<EnumMap<Season, Map<String, List<Fruit>>>, Fruit> accumulator = (map, fruit) -> {
			map.computeIfAbsent(fruit.getSeason(), key -> new HashMap<>())
					.computeIfAbsent(fruit.getName(), key -> new ArrayList<>()).add(fruit);
		};

		BinaryOperator<EnumMap<Season, Map<String, List<Fruit>>>> combiner = (left, right) -> {
			right.entrySet().forEach(entry -> {
				left.merge(entry.getKey(), entry.getValue(), (oldValue, newValue) -> {
					newValue.forEach((key, value) -> {
						oldValue.merge(key, value, (o, n) -> {
							o.addAll(n);
							return o;
						});
					});
					return oldValue;
				});
			});
			return left;
		};

		Function<EnumMap<Season, Map<String, List<Fruit>>>, EnumMap<Season, Map<String, BigDecimal>>> finisher = (
				EnumMap<Season, Map<String, List<Fruit>>> map) -> {
			final EnumMap<Season, Map<String, BigDecimal>> newValue = new EnumMap<>(Season.class);
			map.forEach((Season k, Map<String, List<Fruit>> v) -> {
				Function<Entry<String, List<Fruit>>, BigDecimal> valueFunctionMapper = (
						Entry<String, List<Fruit>> entry) -> {
					return BigDecimal
							.valueOf(entry.getValue().stream().mapToDouble(Fruit::getPrice).average().orElse(0.0d));
				};

				newValue.put(k, v.entrySet().stream().collect(Collectors.toMap(Entry::getKey, valueFunctionMapper)));
			});
			return newValue;
		};

		return Collector.of(supplier, accumulator, combiner, finisher);
	}
}
