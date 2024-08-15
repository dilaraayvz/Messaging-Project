package com.messaging_project.messageservice.controllers;

import com.messaging_project.messageservice.services.abstracts.MessageService;
import com.messaging_project.messageservice.services.dtos.requests.MessageRequest;
import com.messaging_project.messageservice.services.dtos.responses.MessageResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/messages")
public class MessageController {
    private final MessageService messageService;
    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/public")
    public MessageResponse sendMessageViaWebSocket(@Payload MessageRequest messageRequest) {
        // WebSocket üzerinden gelen mesajı veritabanına kaydedelim
        return messageService.sendMessage(messageRequest);

    }
    @GetMapping("/conversation")
    public List<MessageResponse> getConversation(@RequestParam int senderId, @RequestParam int receiverId) {
        return messageService.getConversation(senderId, receiverId);
    }

    @GetMapping("/sent")
    public List<MessageResponse> getSentMessages(@RequestParam int senderId) {
        return messageService.getSentMessages(senderId);
    }

    @GetMapping("/received")
    public List<MessageResponse> getReceivedMessages(@RequestParam int receiverId) {
        return messageService.getReceivedMessages(receiverId);
    }
}