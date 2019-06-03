package com.gauravbytes.kafka.producerdemo;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author Gaurav Rai Mazra
 * <a href="https://gauravbytes.com">Blog</a>
 * <a href="https://grai.dev">Portfolio</a>
 *
 */
public class KafkaProducerDemoWithKeysMain {
	private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProducerDemoWithKeysMain.class);
	
	public static void main(String[] args) {
		// Producer properties
		Properties kafkaProperties = new Properties();
		kafkaProperties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
		kafkaProperties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
		kafkaProperties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
	
		// create kafka producer
		KafkaProducer<String, String> kafkaProducer = new KafkaProducer<>(kafkaProperties);
		
		String topic = "first_topic";
		for (int i = 0; i < 10; i++) {
			final String key = "_id_" + Integer.toString(i);
			final String value = String.format("Hello world from Java Program at [%s]", LocalDateTime.now().toString());
			ProducerRecord<String, String> record = new ProducerRecord<>(topic, key, value);
			
			kafkaProducer.send(record, (RecordMetadata metadata, Exception exception) -> {
				if (null == exception) {
					LOGGER.info("Message sent successfully with key: " + key + " to \tTopic: " + metadata.topic() + "\tPartition: " + metadata.partition() 
					+ "\tOffset: " + metadata.offset() + "\tTimestamp: " + metadata.timestamp());
				}
				else {
					LOGGER.error("Exception occurred while sending message to: " + metadata.topic(), exception);
				}
			}); 
		}
		kafkaProducer.close(Duration.ofSeconds(10l));

	}
}
