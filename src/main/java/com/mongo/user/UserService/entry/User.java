package com.mongo.user.UserService.entry;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collation = "User")
public class User {

    @Id
    private String id;
    private String name;
    private List<String> roleIds;

}
