package com.messaging_project.userservice.services.mappers;
import com.messaging_project.userservice.entities.User;
import com.messaging_project.userservice.services.dtos.request.UserAddRequest;
import com.messaging_project.userservice.services.dtos.request.UserUpdateRequest;
import com.messaging_project.userservice.services.dtos.response.UserAddResponse;
import com.messaging_project.userservice.services.dtos.response.UserGetByIdResponse;
import com.messaging_project.userservice.services.dtos.response.UserUpdateResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toEntity(UserAddRequest userAddRequest);

    UserAddResponse toAddResponse(User user);

    UserGetByIdResponse toGetByIdResponse(User user);

    UserUpdateResponse toUpdateResponse(User user);

    void updateEntity(@MappingTarget User user, UserUpdateRequest userUpdateRequest);
}
