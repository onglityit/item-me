package com.darren.mongorest.service;

import com.darren.mongorest.model.GroceryItem;
import org.springframework.http.ResponseEntity;

public interface GroceryService {
    ResponseEntity<String> updateInsertGroceryItem(GroceryItem groceryItem);
    ResponseEntity<String> deleteGroceryItemById(String Id);
}
