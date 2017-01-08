package com.gauravbytes.vertx;

import java.util.concurrent.TimeUnit;

import io.vertx.core.Vertx;

/**
 * 
 * @author Vert.x periodic task example
 *
 */
public class VertxPeriodicTimerExample {
	public static void main(String[] args) {
		Vertx vertx = Vertx.vertx();
		vertx.setPeriodic(2000, id -> {
			System.out.println("Timer fired with id : " +  id);
		});
		vertx.setPeriodic(5000, id -> {
			throw new RuntimeException("I failed in second timer");
		});
		
		try {
			TimeUnit.SECONDS.sleep(10);
		} catch (InterruptedException e) {
		}
		vertx.close();
	}
}
