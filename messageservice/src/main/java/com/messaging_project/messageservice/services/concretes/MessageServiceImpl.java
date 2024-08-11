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
    @Override
    public Message sendMessage(int senderId, int receiverId, String content) {
        Message message = new Message(senderId, receiverId, content);
        message.setSentAt(LocalDateTime.now());
        return messageRepository.save(message);
    }
    @Override
    public List<Message> getConversation(int senderId, int receiverId) {
        return messageRepository.findBySenderIdAndReceiverId(senderId, receiverId);
    }
    @Override
    public List<Message> getSentMessages(int senderId) {
        return messageRepository.findBySenderId(senderId);
    }
    @Override
    public List<Message> getReceivedMessages(int receiverId) {
        return messageRepository.findByReceiverId(receiverId);
    }

    @Override
    public Message getMessageById(int id) {
        return messageRepository.findById(id);
    }
}
