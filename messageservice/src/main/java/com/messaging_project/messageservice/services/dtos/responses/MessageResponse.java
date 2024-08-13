package com.messaging_project.messageservice.services.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MessageResponse {
    private Long id;
    private int senderId;
    private int receiverId;
    private String content;
    private LocalDateTime sentAt;
}