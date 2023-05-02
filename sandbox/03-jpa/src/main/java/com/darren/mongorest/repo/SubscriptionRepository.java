package com.darren.mongorest.repo;

import com.darren.mongorest.model.Landlord;
import com.darren.mongorest.model.Subscription;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface SubscriptionRepository  extends MongoRepository<Subscription, String> {
    @Query("{id:'?0'}")
    Landlord findSubscriptionOfLandlordByLandlordId(String id);

}
