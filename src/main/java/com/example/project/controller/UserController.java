package com.example.project.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.project.dto.UserDTO;
import com.example.project.service.UserService;
import com.example.project.vo.UserVO;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@RestController
@RequestMapping("/api/users")
public class UserController {

	   private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	    private final UserService userService;

	    @Autowired
	    public UserController(UserService userService) {
	        this.userService = userService;
	    }
    // Create a new user
	    @PostMapping("/create")
	    public ResponseEntity<UserDTO> createUser(@RequestBody @Validated UserVO userVO) {
	        logger.info("Received request to create user: {}", userVO);
	        UserDTO createdUser = userService.createUser(userVO);
	        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
	    }

    // Retrieve all users
	    @GetMapping(value = "/retrieve/{id}") 
	    public ResponseEntity<UserDTO> getUserById(@PathVariable("id") String id) {
	        logger.info("Received request to get user with ID: {}", id);
	        UserDTO userDTO = userService.getUserById(Long.valueOf(id));
	        return new ResponseEntity<>(userDTO, HttpStatus.OK);
	    }

    // Health check endpoint
	    @GetMapping("/health")
	    public ResponseEntity<String> healthCheck() {
	        logger.info("Health check endpoint called");
	        String healthMessage = userService.checkHealth();
	        return ResponseEntity.ok(healthMessage);
	    }
}