package com.darren.mongorest.model;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("contacts")
@Getter @Setter @ToString @EqualsAndHashCode(callSuper = false)
@SuperBuilder @NoArgsConstructor
public class Contact extends BaseEntity{
    private User user;
}
