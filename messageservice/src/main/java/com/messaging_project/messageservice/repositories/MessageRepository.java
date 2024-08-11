package com.messaging_project.messageservice.repositories;

import com.messaging_project.messageservice.entities.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Integer> {
    List<Message> findBySenderIdAndReceiverId(int senderId, int recieverId);
    List<Message> findBySenderId(int senderId);
    List<Message> findByReceiverId(int recieverId);
    Message findById(int id);

}
