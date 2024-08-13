package com.messaging_app.authserver.services.mappers;
import com.messaging_app.authserver.services.dtos.requests.RegisterRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import com.messaging_app.authserver.entities.User;
import com.messaging_app.authserver.services.dtos.requests.LoginRequest;
@Mapper(componentModel = "spring")
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
    @Mapping(target = "password", ignore = true)
    User userFromRegisterRequest(RegisterRequest request);
    User userFromLoginRequest(LoginRequest request);

}