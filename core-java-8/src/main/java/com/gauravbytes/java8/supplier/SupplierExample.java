package com.gauravbytes.java8.supplier;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.gauravbytes.java8.lambda.LambdaTest;

/**
 * 
 * @author Gaurav Rai Mazra
 *
 */
public class SupplierExample {
	public static void main(String[] args) {
		lazyEvalInJavaWithSupplier();
	}

	private static final Logger logger = Logger.getLogger(LambdaTest.class.getName());

	static class LogMessage {
		private String message;

		public LogMessage(String message) {
			this.message = message;
		}

		public String asJson() {
			return "{\"message\" : " + message + "}";
		}
	}

	private static void lazyEvalInJavaWithSupplier() {
		LogMessage message = new LogMessage("I am sinner!!!");
		logger.log(Level.FINE, message.asJson());

		// improved way because if the log level set for logging is not the one you
		// passed, we have wasted effort of decorating logMessage which won't be
		// used by anyone.
		logger.log(Level.FINE, () -> message.asJson());
		// or just
		logger.log(Level.FINE, message::asJson);
	}
}
