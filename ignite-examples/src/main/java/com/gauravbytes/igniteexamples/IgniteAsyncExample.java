package com.gauravbytes.igniteexamples;

import static com.gauravbytes.igniteexamples.IgniteConfigurationHelper.defaultIgniteCfg;

import java.util.concurrent.CountDownLatch;

import org.apache.ignite.Ignite;
import org.apache.ignite.Ignition;
import org.apache.ignite.lang.IgniteFuture;

/**
 * 
 * @author Gaurav Rai Mazra
 * {@link https://lineofcode.in}
 * {@link http://gauravbytes.com}
 *
 */
public class IgniteAsyncExample {
	public static void main(String[] args) {
		CountDownLatch latch = new CountDownLatch(1);
		try(Ignite ignite = Ignition.start(defaultIgniteCfg("ignite-async-node"))) {
			IgniteFuture<String> fut = ignite.compute().callAsync(() -> "Hello from callable!");
			fut.listen(f -> {
				System.out.println(f.get() + " from thread => " + Thread.currentThread().getName());
				latch.countDown();
			});
			try {
				latch.await();
			}
			catch (InterruptedException iex) {
				//Do whatever you want to do Man!
			}
		}
	}
}
