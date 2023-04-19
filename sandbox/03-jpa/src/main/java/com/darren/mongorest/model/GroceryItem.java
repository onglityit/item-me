package com.darren.mongorest.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import jakarta.validation.constraints.NotBlank;

@Document("groceryitems")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class GroceryItem {

    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    @NotBlank(message = "Name cannot be blank")
    private String name;
    private int quantity;
    private String category;
}
