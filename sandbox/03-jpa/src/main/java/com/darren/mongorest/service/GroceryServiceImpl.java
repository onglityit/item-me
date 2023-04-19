package com.darren.mongorest.service;

import com.darren.mongorest.model.GroceryItem;
import com.darren.mongorest.repo.GroceryItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GroceryServiceImpl implements GroceryService{

    @Autowired
    GroceryItemRepository groceryItemRepo;

    static List<GroceryItem> groceryItems = new ArrayList<>();

    public ResponseEntity<String> updateInsertGroceryItem(GroceryItem groceryItem){
        groceryItemRepo.save(groceryItem);
        return new ResponseEntity<>("success", HttpStatus.OK);
    }

    public ResponseEntity<String> deleteGroceryItemById(String id){
        groceryItemRepo.deleteById(id);
        return new ResponseEntity<>("success", HttpStatus.OK);
    }

    private boolean isExist(GroceryItem groceryItem){
        return false;
    }


}
