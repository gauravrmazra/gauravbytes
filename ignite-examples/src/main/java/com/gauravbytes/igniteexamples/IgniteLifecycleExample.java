package com.gauravbytes.igniteexamples;

import static com.gauravbytes.igniteexamples.IgniteConfigurationHelper.defaultIgniteCfg;

import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteException;
import org.apache.ignite.Ignition;
import org.apache.ignite.lifecycle.LifecycleBean;
import org.apache.ignite.lifecycle.LifecycleEventType;

/**
 * 
 * @author Gaurav Rai Mazra {@link https://lineofcode.in}
 *
 */
public class IgniteLifecycleExample {
	static class IgniteLifecycleEventListener implements LifecycleBean {

		@Override
		public void onLifecycleEvent(LifecycleEventType evt) throws IgniteException {
			String message;
			switch (evt) {
			case BEFORE_NODE_START:
				message = "before_node_start event is called!";
				break;
			case AFTER_NODE_START:
				message = "after_node_start event is called!";
				break;
			case BEFORE_NODE_STOP:
				message = "before_node_stop event is called!";
				break;
			case AFTER_NODE_STOP:
				message = "after_node_stop event is called!";
				break;
			default:
				message = "Unknown event";
				break;
			}
			System.out.println(message);
		}
	}
	
	public static void main(String[] args) {
		try (Ignite ignite = Ignition.start(defaultIgniteCfg("ignite-lifecycle-node"))) {
			ignite.compute().broadcast(() -> System.out.println("Message broadcasted to all the nodes!!!"));
		}
	}
}
