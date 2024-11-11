package com.example.project.mapper;

import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class MapperConfig {

	  @Bean
	  @Primary
	    public UserMapper userMapper() {
	        return Mappers.getMapper(UserMapper.class);
 }
}