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
		supplierDelayedExecution();
	}

	private static final Logger logger = Logger.getLogger(LambdaTest.class.getName());

	static class LogMessageDecorator {
		public static String decorate(String log) {
			// some decoration logic
			return "~~~:: " + log + " ::~~~";
		}
	}

	private static void supplierDelayedExecution() {
		logger.log(Level.FINE, LogMessageDecorator.decorate("Decorate me"));

		// improved way because if the log level set for logging is not the one you
		// passed, we have wasted effort of decorating logMessage which won't be
		// used by anyone.
		logger.log(Level.FINE, () -> LogMessageDecorator.decorate("Decorate me"));
	}
}
