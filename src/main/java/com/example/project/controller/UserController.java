package com.example.project.controller;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.project.bo.UserBO;
import com.example.project.dto.UserDTO;
import com.example.project.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(UserController.class);

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Create a new user
    @PostMapping("/create")
    public ResponseEntity<UserBO> createUser(@RequestBody UserDTO userDTO) {
        logger.info("Received request to create user with name: {} and age: {}", userDTO.getName(), userDTO.getAge());

        UserBO createdUser = userService.create(userDTO);
        
        logger.info("User created successfully with ID: " + createdUser.getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }

    // Retrieve all users
    @GetMapping("/retrieve")
    public ResponseEntity<List<UserBO>> retrieveUsers() {
        logger.info("Received request to retrieve all users");

        List<UserBO> users = userService.retrieve();
        
        logger.info("Retrieved " + users.size() + " users successfully");
        return ResponseEntity.ok(users);
    }

    // Health check endpoint
    @GetMapping("/health")
    public ResponseEntity<String> healthCheck() {
        logger.info("Received health check request");

        String healthStatus = userService.healthCheck();
        
        logger.info("Health check response: " + healthStatus);
        return ResponseEntity.ok(healthStatus);
    }
}