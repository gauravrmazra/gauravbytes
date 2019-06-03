package com.gauravbytes.kafka.producerdemo;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;
import java.util.concurrent.CountDownLatch;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.errors.WakeupException;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author Gaurav Rai Mazra <a href="https://gauravbytes.com">Blog</a>
 *         <a href="https://grai.dev">Portfolio</a>
 *
 */
public class KafkaConsumerWithThreadsDemoMain {
	private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumerWithThreadsDemoMain.class);
	public static void main(String[] args) {
		// Create properties

		String groupId = "java-consumer2-application";
		String topic = "first_topic";

		final CountDownLatch latch = new CountDownLatch(1);
		
		LOGGER.info("Creating ConsumerTask");
		KafkaMessageConsumer consumerTask = new KafkaMessageConsumer(groupId, topic, latch);
		Thread worker = new Thread(consumerTask);
		worker.start();


		LOGGER.info("Adding Shutdown hook for ConsumerTask");
		Runtime.getRuntime().addShutdownHook(new Thread( () ->  {

			LOGGER.info("Received terminate singal for driver program");
			consumerTask.close();
			awaitOn(latch);	
		}));
		
		awaitOn(latch);
	}

	private static void awaitOn(final CountDownLatch latch) {
		try {
			latch.await();
		}
		catch (InterruptedException ie) {
			//I got interupted
			ie.printStackTrace();
		}
		LOGGER.info("Gracefully shutdown(ed) the application");
	}

	private static class KafkaMessageConsumer implements Runnable, AutoCloseable {
		private static final Logger LOGGER = LoggerFactory.getLogger(KafkaMessageConsumer.class);

		private final CountDownLatch latch;
		private final KafkaConsumer<String, String> kafkaConsumer;

		public KafkaMessageConsumer(String groupId, String topic, CountDownLatch latch) {
			this.latch = latch;

			Properties consumerProperties = new Properties();
			consumerProperties.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
			consumerProperties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,
					StringDeserializer.class.getName());
			consumerProperties.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,
					StringDeserializer.class.getName());
			consumerProperties.setProperty(ConsumerConfig.GROUP_ID_CONFIG, groupId);
			consumerProperties.setProperty(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");

			// Create a consumer
			KafkaConsumer<String, String> kafkaConsumer = new KafkaConsumer<>(consumerProperties);

			// subscribe on topic
			kafkaConsumer.subscribe(Collections.singleton(topic));

			this.kafkaConsumer = kafkaConsumer;
		}

		@Override
		public void close() {
			this.kafkaConsumer.wakeup();
		}

		@Override
		public void run() {
			try {
				while (true) {
					ConsumerRecords<String, String> records = kafkaConsumer.poll(Duration.ofMillis(100l));
					for (ConsumerRecord<String, String> record : records) {
						LOGGER.info("Message received from Topic: " + record.topic() + "\tPartition: "
								+ record.partition() + "\tOffset: " + record.offset() + "\tKey: " + record.key()
								+ "\tValue: " + record.value());
					}
				}
			} catch (WakeupException wke) {
				LOGGER.info("Received signal to shutdown consumer thread");
			} finally {
				this.kafkaConsumer.close();
				this.latch.countDown();
			}
		}
	}
}
