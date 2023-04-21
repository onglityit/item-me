package com.darren.mongorest.repo;

import com.darren.mongorest.model.Landlord;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LandlordRepository extends MongoRepository<Landlord, String> {
}
