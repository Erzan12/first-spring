package com.erzan.first_spring.service;

import com.erzan.first_spring.dto.UserRequest;
import com.erzan.first_spring.dto.UserResponse;
import com.erzan.first_spring.entity.User;
import com.erzan.first_spring.exception.ResourceNotFoundException;
import com.erzan.first_spring.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(UserRequest request) {
        User user = User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .build();

        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public User updateUser(Long id, UserRequest request) {

        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        user.setName((request.getName()));
        user.setEmail((request.getEmail()));

        return userRepository.save(user);
    }
}
