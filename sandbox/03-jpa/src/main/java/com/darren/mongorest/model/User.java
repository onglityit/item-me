package com.darren.mongorest.model;

import lombok.NoArgsConstructor;
import lombok.Singular;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

@SuperBuilder @NoArgsConstructor

public abstract class User extends BaseEntity{
    @ReadOnlyProperty
    @DocumentReference(lookup="{'user':?#{#self._id} }")
    @Singular
    private List<Contact> contacts;
    private boolean isVerified;
    String username;
}
