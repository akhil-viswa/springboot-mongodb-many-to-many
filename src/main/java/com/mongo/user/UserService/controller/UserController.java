package com.mongo.user.UserService.controller;

import com.mongo.user.UserService.dto.UserRoleDTO;
import com.mongo.user.UserService.entry.User;
import com.mongo.user.UserService.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {

    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public User createUser(@RequestBody  User user) {
        return userService.save(user);
    }


    @GetMapping("/{id}")
    public List<UserRoleDTO> getUserWithRoles(@PathVariable String id) {
        return userService.getUserWithRoles(id);
    }

}
