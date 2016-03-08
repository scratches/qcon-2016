package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableBinding(Source.class)
@RestController
public class SourceApplication {

	@Autowired
	private Source source;

	@RequestMapping("/")
	public String home() {
		source.output().send(MessageBuilder.withPayload("Hello World").build());
		return "OK";
	}

	public static void main(String[] args) {
		SpringApplication.run(SourceApplication.class, args);
	}
}
