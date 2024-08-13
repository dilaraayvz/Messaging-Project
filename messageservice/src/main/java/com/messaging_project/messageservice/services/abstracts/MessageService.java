package com.messaging_project.messageservice.services.abstracts;

import com.messaging_project.messageservice.entities.Message;
import com.messaging_project.messageservice.services.dtos.requests.MessageRequest;
import com.messaging_project.messageservice.services.dtos.responses.MessageResponse;

import java.util.List;
import java.util.Optional;

public interface MessageService {
    MessageResponse sendMessage(MessageRequest messageRequest);
    List<MessageResponse> getConversation(int senderId, int receiverId);
    List<MessageResponse> getSentMessages(int senderId);
    List<MessageResponse> getReceivedMessages(int receiverId);

    Optional<MessageResponse> getMessageById(int id);
}
