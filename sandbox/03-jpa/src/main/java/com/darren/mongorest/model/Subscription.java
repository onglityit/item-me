package com.darren.mongorest.model;


import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("subscriptions") @TypeAlias("subscriptions")
@Getter @Setter @ToString @EqualsAndHashCode(callSuper = false)
@SuperBuilder @NoArgsConstructor
public class Subscription extends BaseEntity {
    @Builder.Default
    private boolean isActive = true;

    //private @NotNull Landlord landlord;
    String companyNickName;
}
