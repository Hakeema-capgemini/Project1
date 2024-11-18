package com.example.project.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.project.bo.UserBO;
import com.example.project.dto.UserDTO;
import com.example.project.util.Constants;
import com.example.project.vo.UserVO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
  
    private final UserBO userBO;

    @Autowired
    public UserServiceImpl(UserBO userBO) {
        this.userBO = userBO;
    }

    @Override
    public UserDTO createUser(UserVO userVO) {
        logger.info("Creating user: {}", userVO);
        ObjectMapper mapper = new ObjectMapper();
        UserDTO userDTO = null;
		try {
			userDTO = mapper.readValue(mapper.writeValueAsString(userVO), UserDTO.class);
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
        UserDTO savedUser = userBO.saveUser(userDTO);  // Call BO layer to save
        logger.info("User created successfully with ID: {}", savedUser.getId());
        return savedUser;
    }
    @Override
    public UserDTO getUserById(Long id) {
        logger.info("Retrieving user with ID: {}", id);
        UserDTO userDTO = userBO.getUserById(id); // Call BO layer to retrieve user
        logger.info("User retrieved successfully: {}", userDTO);
        return userDTO;
    }
    
    @Override
    public String checkHealth() {
        logger.info("Healthcheck endpoint called");
        return Constants.HEALTH_CHECK_MESSAGE;
    }
}
