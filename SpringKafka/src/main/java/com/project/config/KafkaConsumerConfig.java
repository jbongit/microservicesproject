package com.project.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;

public class KafkaConsumerConfig {
	@Value("localhost:9092")
	private String bootstrapServers;

	public Map<String, Object> consumerConfig() {
		HashMap<String, Object> props = new HashMap<>();
		props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
		props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringSerializer.class);
		props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringSerializer.class);
		return props;
	}

	@Bean
	public ProducerFactory<String, String> consumerFactory() {
		return new DefaultKafkaProducerFactory<>(consumerConfig());
	}

	public KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String, String>> factory(
			ConsumerFactory<String, String> consumerFactory) {
		ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(consumerFactory);
		return factory;
	}
}
