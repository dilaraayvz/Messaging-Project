package com.messaging_project.messageservice.services.concretes;

import com.messaging_project.messageservice.entities.Message;
import com.messaging_project.messageservice.repositories.MessageRepository;
import com.messaging_project.messageservice.services.abstracts.MessageService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class MessageServiceImpl implements MessageService {
    private final MessageRepository messageRepository;


    public Message sendMessage(String senderId, String receiverId, String content) {
        Message message = new Message(senderId, receiverId, content);
        message.setSentAt(LocalDateTime.now());
        return messageRepository.save(message);
    }

    public List<Message> getConversation(String senderId, String receiverId) {
        return messageRepository.findBySenderIdAndReceiverId(senderId, receiverId);
    }

    public List<Message> getSentMessages(String senderId) {
        return messageRepository.findBySenderId(senderId);
    }

    public List<Message> getReceivedMessages(String receiverId) {
        return messageRepository.findByReceiverId(receiverId);
    }
}
