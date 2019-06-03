package com.gauravbytes.kafka.producerdemo;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

/**
 * 
 * @author Gaurav Rai Mazra
 * <a href="https://gauravbytes.com">Blog</a>
 * <a href="https://grai.dev">Portfolio</a>
 *
 */
public class KafkaProducerDemoMain {
	public static void main(String[] args) {
		// Producer properties
		Properties kafkaProperties = new Properties();
		kafkaProperties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
		kafkaProperties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
		kafkaProperties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
	
		// create kafka producer
		KafkaProducer<String, String> kafkaProducer = new KafkaProducer<>(kafkaProperties);
		ProducerRecord<String, String> record = new ProducerRecord<>("first_topic", String.format("Hello world from Java Program at [%s]", LocalDateTime.now().toString()));
		kafkaProducer.send(record);
		
		kafkaProducer.close(Duration.ofSeconds(10l));

	}
}
