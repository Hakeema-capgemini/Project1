package com.example.project.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.project.entity.UserEO;

@Repository
public interface UserRepository extends JpaRepository<UserEO, Long> {
	//List<UserEO> saveAll(List<UserEO> users);
	
}

