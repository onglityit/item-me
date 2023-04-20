package com.darren.mongorest.model;

import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

@SuperBuilder @NoArgsConstructor

public abstract class User extends BaseEntity{
    @ReadOnlyProperty
    //@DocumentReference(lazy=true)
    @DocumentReference(lookup="{'user':?#{#self._id} }")
    private List<Contact> contacts;
}
