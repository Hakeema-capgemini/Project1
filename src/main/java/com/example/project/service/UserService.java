package com.example.project.service;

import org.springframework.stereotype.Service;

import com.example.project.dto.UserDTO;
import com.example.project.vo.UserVO;
@Service
public interface UserService {
	
	 UserDTO createUser(UserVO userVO);
	 UserDTO getUserById(Long id);
	 String checkHealth();
	
}
