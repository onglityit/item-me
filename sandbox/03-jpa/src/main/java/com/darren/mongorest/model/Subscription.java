package com.darren.mongorest.model;


import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("subscriptions")
@Getter @Setter @ToString @EqualsAndHashCode(callSuper = false)
@SuperBuilder @NoArgsConstructor
public class Subscription extends BaseEntity{
    @Builder.Default
    private boolean isActive = true;
    private @NotNull Tenant tenant;
}
