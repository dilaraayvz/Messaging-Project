package com.messaging_project.userservice.services.mappers;

import com.messaging_project.userservice.entities.User;
import com.messaging_project.userservice.services.dtos.request.UserCreate;
import com.messaging_project.userservice.services.dtos.request.UserUpdate;
import com.messaging_project.userservice.services.dtos.response.UserGet;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE= Mappers.getMapper(UserMapper.class);
    //source kullanılmadı, hedef ve kaynaktaki field isimleri aynı
    //expression: hesaplama gerekiyorsa kullanılır
    @Mapping(target = "id", ignore = true)//ignore: id dönüşüm sırasında set edilmez çünkü veritabanı trafından otomatik olarak üretilir
    @Mapping(target = "createdDate", expression = "java(java.time.LocalDateTime.now())")
    @Mapping(target = "updatedDate", ignore = true)
    @Mapping(target = "deletedDate", ignore = true)
    @Mapping(target = "isActive", ignore = true)
    User toUser(UserCreate userCreate);

    @Mapping(target = "updatedDate", expression = "java(java.time.LocalDateTime.now())")
    void updateFromDTO(UserUpdate userUpdateDTO, @MappingTarget User user);

    UserGet toUserResponseDTO(User user);
}
