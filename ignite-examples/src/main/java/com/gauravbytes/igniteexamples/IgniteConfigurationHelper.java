package com.gauravbytes.igniteexamples;

import java.util.Collections;

import org.apache.ignite.IgniteLogger;
import org.apache.ignite.configuration.DeploymentMode;
import org.apache.ignite.configuration.IgniteConfiguration;
import org.apache.ignite.logger.java.JavaLogger;
import org.apache.ignite.spi.discovery.DiscoverySpi;
import org.apache.ignite.spi.discovery.tcp.TcpDiscoverySpi;
import org.apache.ignite.spi.discovery.tcp.ipfinder.TcpDiscoveryIpFinder;
import org.apache.ignite.spi.discovery.tcp.ipfinder.multicast.TcpDiscoveryMulticastIpFinder;

/**
 * A helper class containing different type of configurations
 * @author Gaurav Rai Mazra
 *
 */
public class IgniteConfigurationHelper {
	public static IgniteConfiguration helloworldConfiguration() {
		int cpus = Runtime.getRuntime().availableProcessors();
		IgniteConfiguration cfg = new IgniteConfiguration();
		cfg.setIgniteInstanceName("hello-world");
		cfg.setClientMode(true);
		cfg.setPeerClassLoadingEnabled(true);
		cfg.setDeploymentMode(DeploymentMode.CONTINUOUS);
		cfg.setPeerClassLoadingMissedResourcesCacheSize(200);
		cfg.setPublicThreadPoolSize(4 * cpus);
		cfg.setSystemThreadPoolSize(2 * cpus);
		// log frequency in ms
		cfg.setMetricsLogFrequency(30000);
		cfg.setGridLogger(igniteLogger());
		cfg.setDiscoverySpi(multicastDiscoverySpi());
		return cfg;
	}

	private static DiscoverySpi multicastDiscoverySpi() {
		TcpDiscoverySpi spi = new TcpDiscoverySpi();
		spi.setIpFinder(multicastIpFinder());
		return spi;
	}

	private static TcpDiscoveryIpFinder multicastIpFinder() {
		TcpDiscoveryMulticastIpFinder ipFinder = new TcpDiscoveryMulticastIpFinder();
		ipFinder.setAddresses(Collections.singletonList("localhost:47500"));
		return ipFinder;
	}

	private static IgniteLogger igniteLogger() {
		return new JavaLogger();
	}
}
