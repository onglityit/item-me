package com.darren.mongorest.repo;

import com.darren.mongorest.model.ERole;
import com.darren.mongorest.model.Role;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface RoleRepository  extends MongoRepository<Role, String> {
    Optional<Role> findByName(ERole name);
}
