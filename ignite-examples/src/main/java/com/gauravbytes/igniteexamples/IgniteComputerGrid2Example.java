package com.gauravbytes.igniteexamples;

import static com.gauravbytes.igniteexamples.IgniteConfigurationHelper.defaultIgniteCfg;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

import javax.cache.Cache.Entry;

import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCache;
import org.apache.ignite.Ignition;
import org.apache.ignite.binary.BinaryObject;
import org.apache.ignite.cache.query.QueryCursor;
import org.apache.ignite.cache.query.ScanQuery;
import org.apache.ignite.lang.IgniteBiPredicate;
import org.apache.ignite.lang.IgniteCallable;
import org.apache.ignite.resources.IgniteInstanceResource;

/**
 * 
 * @author Gaurav Rai Mazra {@linkplain https://lineofcode.in}
 *         {@linkplain www.gauravbytes.com}
 *
 */
public class IgniteComputerGrid2Example {
	public static void main(String[] args) {
		try (Ignite ignite = Ignition.start(defaultIgniteCfg("cache-reading-compute-engine"))) {
			long cityId = 1;

			ignite.compute().affinityCall("SQL_PUBLIC_CITY", cityId,
					new IgniteCallable<List<String>>() {
						private static final long serialVersionUID = -131151815825938052L;

						@IgniteInstanceResource
						private Ignite currentIgniteInstance;

						@Override
						public List<String> call() throws Exception {
							List<String> names = new ArrayList<>();
							IgniteCache<BinaryObject, BinaryObject> personCache = currentIgniteInstance
									.cache("SQL_PUBLIC_PERSON").withKeepBinary();
							
							IgniteBiPredicate<BinaryObject, BinaryObject> filter = (BinaryObject key, BinaryObject value) -> {
								return key.hasField("CITY_ID") && key.<Long>field("CITY_ID") == cityId;
							};

							ScanQuery<BinaryObject, BinaryObject> query = new ScanQuery<>(filter);

							try (QueryCursor<Entry<BinaryObject, BinaryObject>> cursor = personCache.query(query)) {
								Iterator<Entry<BinaryObject, BinaryObject>> itr = cursor.iterator();

								while (itr.hasNext()) {
									Entry<BinaryObject, BinaryObject> cache = itr.next();
									names.add(cache.getValue().<String>field("NAME"));
								}

							}
							return names;
						}
					}).forEach(System.out::println);;
		}
	}
}
