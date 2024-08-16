package com.messaging_project.messageservice.websocket.chatroom;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "rooms")
public class ChatRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private String id;
    @Column(nullable = false)
    private String chatId;
    @Column(nullable = false)
    private int senderId;
    @Column(nullable = false)
    private int recipientId;


}
