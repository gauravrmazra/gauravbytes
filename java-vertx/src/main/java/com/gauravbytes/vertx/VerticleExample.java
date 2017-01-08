package com.gauravbytes.vertx;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.DeploymentOptions;
import io.vertx.core.Vertx;

public class VerticleExample {
	public static class MyTestVerticle extends AbstractVerticle {
		@Override
		public void start() throws Exception {
			System.out.println("starting mytestverticle");
		}
		
		@Override
		public void stop() throws Exception {
			System.out.println("stoping mytestverticle");
		}
	}
	
	public static void main(String[] args) {
		Vertx vertx = Vertx.vertx();
		DeploymentOptions options = new DeploymentOptions().setWorker(true);
		vertx.deployVerticle(new MyTestVerticle(), options);
		vertx.close();
	}
}
