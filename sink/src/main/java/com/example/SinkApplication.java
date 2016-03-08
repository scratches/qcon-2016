package com.example;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Sink;

@SpringBootApplication
@EnableBinding(Sink.class)
public class SinkApplication {
	
	@Autowired
	private Sink sink;
	
	@PostConstruct
	public void init() {
		sink.input().subscribe(message -> {
			System.err.println(message);
		});
	}

	public static void main(String[] args) {
		SpringApplication.run(SinkApplication.class, args);
	}
}
