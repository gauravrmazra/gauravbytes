package com.gauravbytes.kafka.producerdemo;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author Gaurav Rai Mazra <a href="https://gauravbytes.com">Blog</a>
 *         <a href="https://grai.dev">Portfolio</a>
 *
 */
public class KafkaConsumerDemoMain {
	private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumerDemoMain.class);

	public static void main(String[] args) {
		// Create properties
		Properties consumerProperties = new Properties();
		String groupId = "java-consumer2-application";

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
		kafkaConsumer.subscribe(Collections.singleton("first_topic"));

		// adding consumer closing hook
		Runtime.getRuntime().addShutdownHook(new Thread(() -> {
			kafkaConsumer.close(Duration.ofSeconds(10l));
		}));

		while (true) {
			ConsumerRecords<String, String> records = kafkaConsumer.poll(Duration.ofMillis(100l));
			for (ConsumerRecord<String, String> record : records) {
				LOGGER.info("Message received from Topic: " + record.topic() + "\tPartition: " + record.partition()
						+ "\tOffset: " + record.offset() + "\tKey: " + record.key() + "\tValue: " + record.value());
			}
		}
	}
}
