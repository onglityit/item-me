package com.darren.mongorest.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("groceryitems")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class GroceryItem {

    @Id
    private String id;

    private String name;
    private int quantity;
    private String category;
}
