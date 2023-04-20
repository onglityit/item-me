package com.darren.mongorest.model;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import jakarta.validation.constraints.NotBlank;

@Document("groceryitems")
@Getter @Setter @ToString @EqualsAndHashCode(callSuper = true)
@SuperBuilder @NoArgsConstructor
public class GroceryItem extends BaseEntity{

    @NotBlank(message = "Name cannot be blank")
    private String name;
    private int quantity;
    private String category;
}
