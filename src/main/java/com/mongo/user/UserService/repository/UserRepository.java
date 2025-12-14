package com.mongo.user.UserService.repository;

import com.mongo.user.UserService.entry.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User,String> {
}
