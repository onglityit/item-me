package com.darren.mongorest;

import com.darren.mongorest.repo.GroceryItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class SpringBootSwagger3ExampleApplication {

	@Autowired
	GroceryItemRepository groceryItemRepo;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSwagger3ExampleApplication.class, args);
	}

}
