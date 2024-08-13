package com.messaging_project.messageservice.controllers;

import com.messaging_project.messageservice.entities.Message;
import com.messaging_project.messageservice.services.abstracts.MessageService;
import com.messaging_project.messageservice.services.dtos.requests.MessageRequest;
import com.messaging_project.messageservice.services.dtos.responses.MessageResponse;
import com.messaging_project.messageservice.services.mappers.MessageMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/messages")
public class MessageController {
    private final MessageService messageService;

    @PostMapping
    public MessageResponse sendMessage(@RequestBody MessageRequest requestDTO) {
        return messageService.sendMessage(requestDTO);
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