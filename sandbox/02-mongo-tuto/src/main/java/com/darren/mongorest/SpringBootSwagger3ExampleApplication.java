package com.darren.mongorest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class SpringBootSwagger3ExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSwagger3ExampleApplication.class, args);
	}

}
