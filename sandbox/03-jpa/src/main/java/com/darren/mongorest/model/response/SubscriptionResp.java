package com.darren.mongorest.model.response;

import com.darren.mongorest.model.Subscription;
import lombok.*;

import javax.persistence.Access;
import java.util.List;
@AllArgsConstructor(access = AccessLevel.PRIVATE) @Builder
public class SubscriptionResp extends PagedResponse{
    List<Subscription> subscriptions;
}
