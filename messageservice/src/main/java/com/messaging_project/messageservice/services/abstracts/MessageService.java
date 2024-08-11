package com.messaging_project.messageservice.services.abstracts;

import com.messaging_project.messageservice.entities.Message;

import java.util.List;

public interface MessageService {
     Message sendMessage(int senderId, int receiverId, String content);
    List<Message> getConversation(int senderId, int receiverId);
    List<Message> getSentMessages(int senderId);
    List<Message> getReceivedMessages(int receiverId);

    Message getMessageById(int id);
}
