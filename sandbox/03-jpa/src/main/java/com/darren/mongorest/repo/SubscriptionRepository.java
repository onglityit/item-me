package com.darren.mongorest.repo;

import com.darren.mongorest.model.Subscription;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SubscriptionRepository  extends MongoRepository<Subscription, String> {
}
