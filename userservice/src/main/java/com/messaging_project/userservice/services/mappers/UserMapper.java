package com.messaging_project.userservice.services.mappers;

import com.messaging_project.userservice.entities.User;
import com.messaging_project.userservice.services.dtos.request.UserAddRequest;
import com.messaging_project.userservice.services.dtos.request.UserGetByIdRequest;
import com.messaging_project.userservice.services.dtos.request.UserUpdateRequest;
import com.messaging_project.userservice.services.dtos.response.UserAddResponse;
import com.messaging_project.userservice.services.dtos.response.UserGetByIdResponse;
import com.messaging_project.userservice.services.dtos.response.UserUpdateResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    // DTO to Entity
    User toEntity(UserAddRequest request);

    // Entity to DTO for add response
    UserAddResponse toAddResponse(User user);

    // Update existing entity with DTO values
    void updateEntityFromRequest(UserUpdateRequest request, @MappingTarget User user);

    // Entity to UpdateResponse DTO
    UserUpdateResponse toUpdateResponse(User user);

    // Entity to GetByIdResponse DTO
    UserGetByIdResponse toGetByIdResponse(User user);

    // Entity to GetResponse DTO
    UserGetByIdResponse toGetResponse(User user);

    // Request to Entity mapping for GetRequest if necessary
    User toEntity(UserGetByIdRequest request);
}
