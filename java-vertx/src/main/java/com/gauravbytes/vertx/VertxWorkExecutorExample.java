package com.gauravbytes.vertx;

import java.util.concurrent.CountDownLatch;

import io.vertx.core.AsyncResult;
import io.vertx.core.Future;
import io.vertx.core.Handler;
import io.vertx.core.Vertx;
import io.vertx.core.WorkerExecutor;

public class VertxWorkExecutorExample {
	public static void main(String[] args) {
		Vertx vertx = Vertx.vertx();
		CountDownLatch completion = new CountDownLatch(2);
		
		WorkerExecutor sharedWorker = vertx.createSharedWorkerExecutor("my-shared-pool", 20);
		sharedWorker.executeBlocking(successfulBlockingTask(), responseHandler(completion));
		sharedWorker.executeBlocking(failedBlockingTask(), responseHandler(completion));
		vertx.close();
	}

	private static Handler<AsyncResult<String>> responseHandler(final CountDownLatch completion) {
		return response -> {
			completion.countDown();
			if (response.succeeded()) {
				System.out.println(response.result());
			}
			else {
				System.out.println(response.cause());
			}
		};
	}

	private static Handler<Future<String>> successfulBlockingTask() {
		return future -> {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
			}
			future.complete("I am completed successfully.");
		};
	}
	
	private static Handler<Future<String>> failedBlockingTask() {
		return future -> {
			throw new RuntimeException("I failed");
		};
	}
}
