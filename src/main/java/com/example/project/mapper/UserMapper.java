package com.example.project.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.example.project.bo.UserBO;
import com.example.project.dto.UserDTO;
import com.example.project.entity.UserEO;


@Mapper(componentModel = "spring")
	public interface UserMapper {
	
	UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
	
	UserEO dtoToEntity(UserDTO dto);

    UserBO entityToBO(UserEO entity);
		
}
