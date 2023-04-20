package com.darren.mongorest;

import com.darren.mongorest.repo.GroceryItemRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

import static org.mockito.Mockito.mock;


@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class GroceryServiceMockTests {

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
