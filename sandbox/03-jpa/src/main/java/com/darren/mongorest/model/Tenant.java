package com.darren.mongorest.model;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("users") @TypeAlias("tenants")
@Getter @Setter @ToString @EqualsAndHashCode(callSuper = false)
@SuperBuilder @NoArgsConstructor

public class Tenant extends User{

}
