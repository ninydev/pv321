package org.itstep.chat.mappers;

import org.itstep.chat.dto.users.CreateUserDto;
import org.itstep.chat.entities.UserModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.security.core.userdetails.UserDetails;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    // UserDetails mapUserModelToUserDetails(UserModel userModel);

    UserModel toModel(CreateUserDto dto);

    // LoginUserDto toDto(UserModel model);
    // UserModel toModel(RegisterUserDto dto);
    // RegisterUserDto toDto(UserModel model);
    // UserModel toModel(UpdateUserDto dto);
    // UpdateUserDto toDto(UserModel model);
}
