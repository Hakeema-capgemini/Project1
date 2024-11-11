package com.example.project.service;


import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.example.project.bo.UserBO;
import com.example.project.dao.UserRepository;
import com.example.project.dto.UserDTO;
import com.example.project.entity.UserEO;
import com.example.project.mapper.UserMapper;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository,UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public UserBO create(UserDTO dto) {
        logger.info("Starting to create user with name: {} and age: {}", dto.getName(), dto.getAge());

        UserEO userEO = userMapper.dtoToEntity(dto);

        UserEO savedUser = userRepository.save(userEO);
        logger.info("User created with ID: {}", savedUser.getId());

        return userMapper.entityToBO(savedUser);
    }
    @Override
    public List<UserBO> retrieve() {
        logger.info("Retrieving all users from the database");

        List<UserEO> users = userRepository.findAll();

        List<UserBO> userBOs = users.stream()
                .map(userMapper::entityToBO)
                .collect(Collectors.toList());

        logger.info("Successfully retrieved {} users", userBOs.size());
        return userBOs;
    }
    
    @Override
    public String healthCheck() {
        logger.info("Health check performed, application is running.");
        return "Service is running";
  }
}
