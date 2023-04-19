package com.darren.mongorest;

import com.darren.mongorest.model.GroceryItem;
import com.darren.mongorest.repo.GroceryItemRepository;
import com.darren.mongorest.service.GroceryService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.UUID;



import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class GroceryServiceTests {

	static String generatedUuid;

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
		GroceryItemRepository groceryItemRepository = mock(GroceryItemRepository.class);


	}

}
