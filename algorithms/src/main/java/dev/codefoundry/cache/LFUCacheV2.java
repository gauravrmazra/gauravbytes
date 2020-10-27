package dev.codefoundry.cache;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.TreeMap;

public class LFUCacheV2 {
	class Value {
		int value;
		int counter;

		Value(int value, int cnt) {
			this.value = value;
			this.counter = cnt;
		}

		@Override
		public String toString() {
			return "[value: " + this.value + ", counter: " + this.counter + "]";
		}
	}

	private int capacity;
	private Map<Integer, Value> values = new HashMap<>();
	private TreeMap<Integer, LinkedHashSet<Integer>> leastAccessed = new TreeMap<>();

	public LFUCacheV2(int capacity) {
		this.capacity = capacity;
	}

	public int get(int key) {
		Value v = this.values.get(key);
		if (v == null)
			return -1;

		removeNode(v.counter, key);
		v.counter++;

		this.leastAccessed.computeIfAbsent(v.counter, k -> new LinkedHashSet<>()).add(key);

		return v.value;
	}

	private void removeNode(int freq, int key) {
		LinkedHashSet<Integer> l = this.leastAccessed.get(freq);
		l.remove(key);
		if (l.size() == 0) {
			this.leastAccessed.remove(freq);
		}

	}

	public void set(int key, int val) {
		if (this.values.size() == this.capacity) {
			int leastFreq = this.leastAccessed.firstKey();
			LinkedHashSet<Integer> l = this.leastAccessed.get(leastFreq);
			Iterator<Integer> itr = l.iterator();
			int toRemove = -1;
			if (itr.hasNext()) {
				Integer k = itr.next();
				toRemove = k;
				this.values.remove(k);
				itr.remove();
			}
			removeNode(leastFreq, toRemove);
			
		}

		Value v = this.values.computeIfAbsent(key, (k) -> new Value(val, -1));
		if (v.counter == -1) {
			v.counter++;
			this.leastAccessed.computeIfAbsent(v.counter, k -> new LinkedHashSet<>()).add(key);
		} else {
			this.leastAccessed.get(v.counter).remove(key);
			v.counter++;
			v.value = val;

			this.leastAccessed.computeIfAbsent(v.counter, k -> new LinkedHashSet<>()).add(key);
		}
	}

	public static void main(String[] args) {
		firstTestCase();
		long start = System.currentTimeMillis();
		tleTestCase();
		System.out.println("TLE Time: " + (System.currentTimeMillis() - start));
	}
	
	private static void tleTestCase() {
		LFUCacheV2 cache = new LFUCacheV2(1);
		for (int i = 0; i < 100000; i++) {
			cache.set(i, i);
		}
	}

	private static void firstTestCase() {
		LFUCacheV2 cache = new LFUCacheV2(3);
		cache.set(1, 10);
		System.out.println(cache.get(1));

		cache.set(2, 20);
		cache.set(3, 30);
		cache.set(4, 40);

		System.out.println(cache.get(3));
		System.out.println(cache.get(2));
	}
}
