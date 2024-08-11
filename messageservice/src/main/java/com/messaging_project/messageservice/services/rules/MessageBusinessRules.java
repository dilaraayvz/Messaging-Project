package com.messaging_project.messageservice.services.rules;

import com.messaging_project.messageservice.repositories.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MessageBusinessRules {
    private final MessageRepository messageRepository;

    public void checkIfUserCanSendMessage(String senderId, String receiverId) {
        // Kullanıcının mesaj gönderip gönderemeyeceğini kontrol edin
        if (senderId.equals(receiverId)) {
            throw new RuntimeException("Users cannot send messages to themselves.");
        }
        // Diğer iş kuralları
    }
}
