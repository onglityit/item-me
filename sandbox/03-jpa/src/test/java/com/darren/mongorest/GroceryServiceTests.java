package com.darren.mongorest;

import com.darren.mongorest.model.GroceryItem;
import com.darren.mongorest.repo.GroceryItemRepository;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;


@TestInstance(Lifecycle.PER_CLASS)
@SpringBootTest

public class GroceryServiceTests {

	static String generatedUuid;

	@Autowired
	GroceryItemRepository groceryItemRepository;

	@BeforeAll
	static void setup(){
		generatedUuid = UUID.randomUUID().toString();
	}

	@Test
	void contextLoads() {

	}



	@Test
	@Order(1)
	void givenGroceryItemRepository_whenInsertGroceryItem_shouldFindGroceryItem(){

		GroceryItem groceryItemFound,
				groceryItemInserted = new GroceryItem(generatedUuid, "hello", 1, "a");
		groceryItemRepository.save(groceryItemInserted);
		groceryItemFound = groceryItemRepository.findItemById(generatedUuid);
		assertNotNull(groceryItemFound);
		assertEquals(groceryItemInserted, groceryItemFound);
		groceryItemRepository.deleteById(generatedUuid);


	}

	@AfterAll
	public static void teardown(){

	}

}
