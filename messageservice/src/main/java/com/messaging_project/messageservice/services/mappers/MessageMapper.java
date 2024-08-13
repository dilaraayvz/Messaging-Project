package com.messaging_project.messageservice.services.mappers;

import com.messaging_project.messageservice.entities.Message;
import com.messaging_project.messageservice.services.dtos.requests.MessageRequest;
import com.messaging_project.messageservice.services.dtos.responses.MessageResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper
public interface MessageMapper {
    MessageMapper INSTANCE = Mappers.getMapper(MessageMapper.class);

    Message toEntity(MessageRequest messageRequest);
    MessageResponse toDTO(Message message);
}
