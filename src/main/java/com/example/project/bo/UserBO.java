package com.example.project.bo;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.project.dto.UserDTO;
import com.example.project.entity.UserEntity;
import com.example.project.eo.UserEO;
import com.example.project.util.Constants;
@Service
public class UserBO {
	private static final Logger logger = LoggerFactory.getLogger(UserBO.class);

    @Autowired
    private UserEO userEO;

    public UserDTO saveUser(UserDTO userDTO) {
        logger.info(Constants.USER_CREATION_LOG);
        UserEntity userEntity =  userEO.save(userDTO);
        if (null != userEntity ) {
        	userDTO.setId(userEntity.getId());
        	return userDTO;
	  }
		return null;
    }
	

	public UserDTO getUserById(Long id) {
		
		UserEntity userEntity =  userEO.retrieve(id);
        if (null != userEntity ) {
        	UserDTO userDTO = new UserDTO(); 
        	userDTO.setId(userEntity.getId( ));
        	userDTO.setName(userEntity.getName());
        	userDTO.setAge(userEntity.getAge());
        	return userDTO;
	  }
		return null;
	}
	
}
