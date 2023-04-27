package com.darren.mongorest.model;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

@Document("users") @TypeAlias("users")
@Data
@SuperBuilder @NoArgsConstructor @AllArgsConstructor(access = AccessLevel.PRIVATE)

public class Landlord extends User{
    @ReadOnlyProperty
    @DocumentReference(lookup="{'landlord':?#{#self._id} }")
    private List<Subscription> subscriptions;
}
