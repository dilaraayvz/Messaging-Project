package com.messaging_project.messageservice.services.dtos.requests;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MessageRequest {
    private int senderId;
    private int receiverId;
    private String content;
}
