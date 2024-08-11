package com.messaging_project.messageservice.controllers;

import com.messaging_project.messageservice.entities.Message;
import com.messaging_project.messageservice.services.abstracts.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/messages")
public class MessageController {
    private final MessageService messageService;


    @PostMapping
    public Message sendMessage(@RequestParam int senderId, @RequestParam int receiverId, @RequestParam String content) {
        return messageService.sendMessage(senderId, receiverId, content);
    }

    @GetMapping("/conversation")
    public List<Message> getConversation(@RequestParam int senderId, @RequestParam int receiverId) {
        return messageService.getConversation(senderId, receiverId);
    }

    @GetMapping("/sent")
    public List<Message> getSentMessages(@RequestParam int senderId) {
        return messageService.getSentMessages(senderId);
    }

    @GetMapping("/received")
    public List<Message> getReceivedMessages(@RequestParam int receiverId) {
        return messageService.getReceivedMessages(receiverId);
    }
}