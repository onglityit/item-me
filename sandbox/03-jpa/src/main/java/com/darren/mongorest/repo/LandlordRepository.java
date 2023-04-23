package com.darren.mongorest.repo;

import com.darren.mongorest.model.Landlord;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface LandlordRepository extends MongoRepository<Landlord, String> {
    @Query("{id:'?0'}")
    Landlord findLandlordById(String id);
}
