package com.darren.mongorest.controller;

import com.darren.mongorest.model.GroceryItem;
import com.darren.mongorest.service.GroceryService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.Callable;

@RestController
@RequestMapping("/api")
public class GroceryController {
    @Autowired
    GroceryService groceryService;

    @Operation(summary = "addGroceryItem")
    @PostMapping("/addGroceryItem")
    public Callable<ResponseEntity<String>> addGroceryItem(@RequestBody GroceryItem groceryItem){
        return () -> {
            return groceryService.updateInsertGroceryItem(groceryItem);
        };
    }

    @DeleteMapping("/deleteGroceryItem/{id}")
    public Callable<ResponseEntity<String>> deleteGroceryItemById(@PathVariable("id") String id){
        return () -> {
            return groceryService.deleteGroceryItemById(id);
        };
    }

}
