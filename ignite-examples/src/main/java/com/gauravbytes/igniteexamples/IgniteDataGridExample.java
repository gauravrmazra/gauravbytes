package com.gauravbytes.igniteexamples;

import static com.gauravbytes.igniteexamples.IgniteConfigurationHelper.defaultIgniteCfg;

import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCache;
import org.apache.ignite.Ignition;

/**
 * 
 * @author Gaurav Rai Mazra {@link https://lineofcode.in} {@link http://gauravbytes.comß}
 *
 */
public class IgniteDataGridExample {
	public static void main(String[] args) {
		try (Ignite ignite = Ignition.start(defaultIgniteCfg("ignite-data-grid"))) {
			IgniteCache<Integer, String> personCache = ignite.getOrCreateCache("personCache");
			for (int i = 0; i < 10; i++) {
				personCache.put(i, "Gaurav " + i);
			}
			
			for (int i = 0; i < 10; i++) {
				System.out.println(personCache.get(i));
			}
		}
	}
}
