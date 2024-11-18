package com.example.project.eo;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.project.dao.UserRepository;
import com.example.project.dto.UserDTO;
import com.example.project.entity.UserEntity;
import com.example.project.util.Constants;

@Service
public class UserEO {

		 private static final Logger logger = LoggerFactory.getLogger(UserEO.class);

		    @Autowired
		    private UserRepository userRepository;

		    public UserEntity save(UserDTO userDTO) {
		        UserEntity userEntity = new UserEntity();
		        userEntity.setName(userDTO.getName());
		        userEntity.setAge(userDTO.getAge());
		        logger.info(Constants.USER_CREATION_LOG);
		        userRepository.flush();
		        return userRepository.save(userEntity);
	  }
		    public UserEntity retrieve(Long userID ) {
				return userRepository.getById(userID);
		    	
		    }
		    
	}	    

