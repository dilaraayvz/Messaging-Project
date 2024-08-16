package com.messaging_project.messageservice.services.dtos.responses;

import lombok.*;

import java.time.LocalDateTime;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class MessageResponse {
    private Long id;
    private String chatId;
    private int senderId;
    private int receiverId;
    private String content;
    private LocalDateTime sentAt;

}