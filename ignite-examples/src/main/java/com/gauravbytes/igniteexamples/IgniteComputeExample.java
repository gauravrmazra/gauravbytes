package com.gauravbytes.igniteexamples;

import static com.gauravbytes.igniteexamples.IgniteConfigurationHelper.defaultIgniteCfg;
import static java.util.stream.Collectors.toList;

import java.util.Collection;
import java.util.stream.IntStream;

import org.apache.ignite.Ignite;
import org.apache.ignite.Ignition;
import org.apache.ignite.lang.IgniteCallable;

/**
 * 
 * @author Gaurav Rai Mazra {@link https://lineofcode.in}
 *
 */
public class IgniteComputeExample {
	static class NumberMultiplier implements IgniteCallable<Integer> {
		private static final long serialVersionUID = 7645655734200971503L;
		private Integer number;

		public NumberMultiplier(Integer number) {
			this.number = number;
		}
		
		@Override
		public Integer call() throws Exception {
			return number * number;
		}
	}

	public static void main(String[] args) {
		Collection<IgniteCallable<Integer>> jobs = IntStream.range(1, 11)
				.mapToObj(NumberMultiplier::new).collect(toList());

		try (Ignite ignite = Ignition.start(defaultIgniteCfg("compute-grid"))) {
			ignite.compute().call(jobs).forEach(System.out::println);
		}
	}
}
