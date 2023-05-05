package com.darren.mongorest.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data @EqualsAndHashCode(callSuper = false)
@SuperBuilder @NoArgsConstructor
@AllArgsConstructor
@Document("users") @TypeAlias("users")

public class User extends BaseEntity{
    //@ReadOnlyProperty
    //@DocumentReference(lookup="{'user':?#{#self._id} }")
    //@Singular
    //private List<Contact> contacts;
    private boolean isVerified;
    @NotBlank @Size(max = 20)
    String username;
    @NotBlank @Size(max = 120)
    String password;
    @NotBlank @Size(max = 50)
    String email;
    @DBRef
    private Set<Role> roles = new HashSet<>();
}
