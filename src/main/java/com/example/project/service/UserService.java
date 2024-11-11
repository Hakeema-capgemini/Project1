package com.example.project.service;

import java.util.List;

import com.example.project.bo.UserBO;
import com.example.project.dto.UserDTO;

public interface UserService {
	
	UserBO create(UserDTO dto);
	List<UserBO> retrieve();
	 String healthCheck();
	
}
