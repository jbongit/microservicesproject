package com.project.controllers;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.MessageRequest;

@RestController
@RequestMapping("/kafka")
public class KafkaController {
	private KafkaTemplate<String, String> kafkaTemplate;

	public KafkaController(KafkaTemplate<String, String> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}

	@PostMapping
	public void publish(@RequestBody MessageRequest request) {
		kafkaTemplate.send("DemoKafka", request.message());
	}
}
