package com.erzan.first_spring.controller;

import com.erzan.first_spring.dto.UserRequest;
import com.erzan.first_spring.entity.User;
import com.erzan.first_spring.repository.UserRepository;
import com.erzan.first_spring.service.UserService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public User createUser(@Valid @RequestBody UserRequest request) {
        return userService.createUser(request);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
}
