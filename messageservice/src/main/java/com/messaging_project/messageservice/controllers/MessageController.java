package com.messaging_project.messageservice.controllers;

import com.messaging_project.messageservice.services.abstracts.MessageService;
import com.messaging_project.messageservice.services.dtos.requests.MessageRequest;
import com.messaging_project.messageservice.services.dtos.responses.MessageResponse;
import com.messaging_project.messageservice.websocket.chatroom.ChatNotification;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/messages")
public class MessageController {
    private final MessageService messageService;
    private final SimpMessagingTemplate messagingTemplate;

    @GetMapping("/messages/{senderId}/{recipientId}")
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

    @MessageMapping("/chat")
    public void processMessage(@Payload MessageRequest messageRequest) {
        Optional<MessageResponse> savedMsg = messageService.save(messageRequest);
        if (savedMsg.isPresent()) {
            MessageResponse messageResponse = savedMsg.get();
            messagingTemplate.convertAndSendToUser(
                    String.valueOf(messageRequest.getReceiverId()),
                    "/queue/messages",
                    ChatNotification.builder()
                            .id(String.valueOf(messageResponse.getId()))
                            .senderId(String.valueOf(messageResponse.getSenderId()))
                            .recipientId(String.valueOf(messageResponse.getReceiverId()))
                            .content(messageResponse.getContent())
                            .build()
            );
        }
    }
}