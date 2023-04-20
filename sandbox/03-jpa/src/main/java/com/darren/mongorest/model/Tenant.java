package com.darren.mongorest.model;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("tenants")
@Getter @Setter @ToString @EqualsAndHashCode(callSuper = true)
@SuperBuilder @NoArgsConstructor

public class Tenant extends BaseEntity{

}
