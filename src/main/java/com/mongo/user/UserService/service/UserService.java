package com.mongo.user.UserService.service;


import com.mongo.user.UserService.dto.UserRoleDTO;
import com.mongo.user.UserService.entry.User;
import com.mongo.user.UserService.repository.UserRepository;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final MongoTemplate mongoTemplate;

    public UserService(UserRepository userRepository, MongoTemplate mongoTemplate) {
        this.userRepository = userRepository;
        this.mongoTemplate = mongoTemplate;
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public List<UserRoleDTO> getUserWithRoles(String userId) {
        Aggregation aggregation = Aggregation.newAggregation(
                Aggregation.match(Criteria.where("_id").is(userId)),
                Aggregation.lookup("roles", "roleIds", "_id", "roles")
        );


        AggregationResults<UserRoleDTO> result =
                mongoTemplate.aggregate(aggregation, "users", UserRoleDTO.class);


        return result.getMappedResults();
    }

}
