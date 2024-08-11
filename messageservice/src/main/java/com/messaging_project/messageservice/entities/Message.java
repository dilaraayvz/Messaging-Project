package com.messaging_project.messageservice.entities;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "messages")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Message {

    public Message(String senderId, String receiverId, String content) {
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.content = content;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String senderId;

    @Column(nullable = false)
    private String receiverId;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private LocalDateTime sentAt;

}