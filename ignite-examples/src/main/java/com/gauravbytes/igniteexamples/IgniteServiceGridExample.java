package com.gauravbytes.igniteexamples;

import static com.gauravbytes.igniteexamples.IgniteConfigurationHelper.defaultIgniteCfg;

import java.time.LocalDateTime;

import org.apache.ignite.Ignite;
import org.apache.ignite.Ignition;
import org.apache.ignite.services.Service;
import org.apache.ignite.services.ServiceContext;

/**
 * 
 * @author Gaurav Rai Mazra {@link https://lineofcode.in}
 *
 */
public class IgniteServiceGridExample {
	interface TimeService extends Service {
		public LocalDateTime currentDateTime();
	}
	
	static class TimeServiceImpl implements TimeService {
		private static final long serialVersionUID = 3977097368864906176L;

		@Override
		public void cancel(ServiceContext ctx) {
			System.out.println("Service is cancelled!");
		}

		@Override
		public void init(ServiceContext ctx) throws Exception {
			System.out.println("Service is initialized!");
		}

		@Override
		public void execute(ServiceContext ctx) throws Exception {
			System.out.println("Service is deployed!");
		}

		@Override
		public LocalDateTime currentDateTime() {
			return LocalDateTime.now();
		}
	}
	
	public static void main(String[] args) {
		try (Ignite ignite = Ignition.start(defaultIgniteCfg("ignite-service-grid"))) {
			ignite.services().deployClusterSingleton("TimeServiceImpl", new TimeServiceImpl());
			
			TimeService timeService = ignite.services().serviceProxy("TimeServiceImpl", TimeService.class, false);
			
			System.out.println("Current time is: " + timeService.currentDateTime());
		}
	}
}
