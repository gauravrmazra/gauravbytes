package com.gauravbytes.kafka.producerdemo;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author Gaurav Rai Mazra <a href="https://gauravbytes.com">Blog</a>
 *         <a href="https://grai.dev">Portfolio</a>
 *
 */
public class KafkaConsumerAssignAndSeekDemoMain {
	private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumerAssignAndSeekDemoMain.class);

	public static void main(String[] args) {
		// Create properties
		Properties consumerProperties = new Properties();

		consumerProperties.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
		consumerProperties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,
				StringDeserializer.class.getName());
		consumerProperties.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,
				StringDeserializer.class.getName());
		consumerProperties.setProperty(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");

		// Create a consumer
		KafkaConsumer<String, String> kafkaConsumer = new KafkaConsumer<>(consumerProperties);


		TopicPartition partition = new TopicPartition("first_topic", 0);
		//Assign a partition to read from
		kafkaConsumer.assign(Collections.singletonList(partition));
		
		long offsetFrom = 5l;
		//seek message from 
		kafkaConsumer.seek(partition, offsetFrom);
		
		int noOfMessagesToRead = 5;
		boolean keepReading = true;
		
		while (keepReading) {
			ConsumerRecords<String, String> records = kafkaConsumer.poll(Duration.ofMillis(100l));
			for (ConsumerRecord<String, String> record : records) {
				LOGGER.info("Message received from Topic: " + record.topic() + "\tPartition: " + record.partition()
						+ "\tOffset: " + record.offset() + "\tKey: " + record.key() + "\tValue: " + record.value());
				
				keepReading = noOfMessagesToRead-- > 0;
				
				if (!keepReading) break;
			}
		}
		
		kafkaConsumer.close(Duration.ofSeconds(10l));
	}
}
