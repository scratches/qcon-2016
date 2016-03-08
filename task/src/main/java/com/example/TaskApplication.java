package com.example;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.task.configuration.EnableTask;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.ContextClosedEvent;

@SpringBootApplication
@EnableTask
public class TaskApplication {
	
	@Bean
	public ApplicationRunner runner(ApplicationContext context) {
		return app -> {
			System.err.println("Hello World in Task");
			context.publishEvent(new ContextClosedEvent(context));
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(TaskApplication.class, args);
	}
}
