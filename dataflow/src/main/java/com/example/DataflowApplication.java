package com.example;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.dataflow.artifact.registry.ArtifactRegistration;
import org.springframework.cloud.dataflow.artifact.registry.ArtifactRegistry;
import org.springframework.cloud.dataflow.core.ArtifactCoordinates;
import org.springframework.cloud.dataflow.core.ArtifactType;
import org.springframework.cloud.dataflow.server.EnableDataFlowServer;

@SpringBootApplication
@EnableDataFlowServer
public class DataflowApplication {

	@Autowired
	private ArtifactRegistry registry;

	@PostConstruct
	public void init() {
		registry.save(new ArtifactRegistration("mysource", ArtifactType.source,
				ArtifactCoordinates.parse("com.example:source:0.0.1-SNAPSHOT")));
	}

	public static void main(String[] args) {
		SpringApplication.run(DataflowApplication.class, args);
	}
}
