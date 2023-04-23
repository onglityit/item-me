package com.darren.mongorest.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import com.darren.mongorest.model.GroceryItem;

import java.util.List;

public interface GroceryItemRepository extends MongoRepository<GroceryItem, String> {

    //@Query("{name:'?0'}")
    //GroceryItem findItemByName(String name);
    @Query("{id:'?0'}")
    GroceryItem findItemById(String id);

    //@Query(value="{category:'?0'}", fields="{'name' : 1, 'quantity' : 1}")
    //List<GroceryItem> findAll(String category);

    //public long count();

}
