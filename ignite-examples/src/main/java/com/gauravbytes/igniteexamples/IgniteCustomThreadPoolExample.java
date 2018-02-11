package com.gauravbytes.igniteexamples;

import static com.gauravbytes.igniteexamples.IgniteConfigurationHelper.defaultIgniteCfg;

import org.apache.ignite.Ignite;
import org.apache.ignite.Ignition;
import org.apache.ignite.configuration.ExecutorConfiguration;
import org.apache.ignite.configuration.IgniteConfiguration;
import org.apache.ignite.lang.IgniteRunnable;
import org.apache.ignite.resources.IgniteInstanceResource;

/**
 * 
 * @author Gaurav Rai Mazra
 * {@link https://lineofcode.in}
 * {@link http://gauravbytes.com}
 *
 */
public class IgniteCustomThreadPoolExample {
	static class InternalTask implements IgniteRunnable {
		private static final long serialVersionUID = 5169676352276118235L;

		@Override
		public void run() {
			System.out.println("Internal task executed!");
		}
	}
	
	static class OuterTask implements IgniteRunnable {
		private static final long serialVersionUID = 602712410415356484L;

		@IgniteInstanceResource
		private Ignite ignite;
		
		@Override
		public void run() {
			System.out.println("Ignite Outer task!");
			ignite.compute().withExecutor("myCustomThreadPool").run(new InternalTask());
		}
		
	}
	
	public static void main(String[] args) {
		IgniteConfiguration icfg = defaultIgniteCfg("custom-thread-pool-grid");
		icfg.setExecutorConfiguration(new ExecutorConfiguration("myCustomThreadPool").setSize(16));
		
		try (Ignite ignite = Ignition.start(icfg)) {
			ignite.compute().run(new OuterTask());
		}
	}
}
