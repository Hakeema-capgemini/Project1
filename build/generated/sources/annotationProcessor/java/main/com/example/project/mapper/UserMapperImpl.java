package com.example.project.mapper;

import com.example.project.dto.UserDTO;
import com.example.project.vo.UserVO;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-24T23:48:15+0530",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.10.2.jar, environment: Java 17.0.11 (Eclipse Adoptium)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDTO toDTO(UserVO userVO) {
        if ( userVO == null ) {
            return null;
        }

        UserDTO userDTO = new UserDTO();

        userDTO.setId( userVO.getId() );
        userDTO.setName( userVO.getName() );
        userDTO.setAge( userVO.getAge() );

        return userDTO;
    }

    @Override
    public UserVO toVO(UserDTO userDTO) {
        if ( userDTO == null ) {
            return null;
        }

        UserVO userVO = new UserVO();

        userVO.setId( userDTO.getId() );
        userVO.setName( userDTO.getName() );
        userVO.setAge( userDTO.getAge() );

        return userVO;
    }
}
