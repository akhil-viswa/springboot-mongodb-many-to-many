package com.mongo.user.UserService.dto;

import com.mongo.user.UserService.entry.Role;
import lombok.Data;
import java.util.List;

@Data
public class UserRoleDTO {
    private String id;
    private String name;
    private List<Role> roles;
}
