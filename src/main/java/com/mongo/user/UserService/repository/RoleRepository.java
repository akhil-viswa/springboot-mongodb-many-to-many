package com.mongo.user.UserService.repository;

import com.mongo.user.UserService.entry.Role;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RoleRepository extends MongoRepository<Role,String> {
}
