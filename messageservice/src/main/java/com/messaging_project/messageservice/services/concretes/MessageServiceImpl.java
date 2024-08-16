package com.messaging_project.messageservice.services.concretes;

import com.messaging_project.messageservice.clients.AuthServiceClient;
import com.messaging_project.messageservice.clients.dtos.UserGetResponse;
import com.messaging_project.messageservice.entities.Message;
import com.messaging_project.messageservice.repositories.MessageRepository;
import com.messaging_project.messageservice.services.abstracts.MessageService;
import com.messaging_project.messageservice.services.dtos.requests.MessageRequest;
import com.messaging_project.messageservice.services.dtos.responses.MessageResponse;
import com.messaging_project.messageservice.services.mappers.MessageMapper;
import com.messaging_project.messageservice.websocket.chatroom.ChatRoomService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MessageServiceImpl implements MessageService {
    private final AuthServiceClient authServiceClient;
    private final MessageRepository messageRepository;
    private final MessageMapper messageMapper;
    private final ChatRoomService chatRoomService;

    @Override
    public MessageResponse sendMessage(MessageRequest messageRequest) {
        UserGetResponse sender = authServiceClient.getUserById(messageRequest.getSenderId());
        UserGetResponse receiver = authServiceClient.getUserById(messageRequest.getReceiverId());

        if (sender != null && receiver != null) {
            Message message = messageMapper.toEntity(messageRequest);
            message.setSentAt(LocalDateTime.now());
            Message savedMessage = messageRepository.save(message);
            return messageMapper.toDTO(savedMessage);
        } else {
            throw new IllegalArgumentException("Geçersiz kullanıcı.");
        }
    }

    @Override
    public List<MessageResponse> getConversation(int senderId, int receiverId) {
        List<Message> messages = messageRepository.findBySenderIdAndReceiverId(senderId, receiverId);
        return messages.stream()
                .map(messageMapper::toDTO)
                .toList();
    }

    @Override
    public List<MessageResponse> getSentMessages(int senderId) {
        List<Message> messages = messageRepository.findBySenderId(senderId);
        return messages.stream()
                .map(messageMapper::toDTO)
                .toList();
    }

    @Override
    public List<MessageResponse> getReceivedMessages(int receiverId) {
        List<Message> messages = messageRepository.findByReceiverId(receiverId);
        return messages.stream()
                .map(messageMapper::toDTO)
                .toList();
    }

    @Override
    public Optional<MessageResponse> getMessageById(int id) {
        return messageRepository.findById(id)
                .map(message -> messageMapper.toDTO(message));
    }

    @Override
    public Optional<MessageResponse> save(MessageRequest messageRequest) {
        var chatId=chatRoomService.getChatRoomId(messageRequest.getSenderId(),messageRequest.getReceiverId(),true).orElseThrow();
        Message message = MessageMapper.INSTANCE.toEntity(messageRequest);
        messageRepository.save(message);
        MessageResponse messageResponse=MessageMapper.INSTANCE.toDTO(message);
        return Optional.ofNullable(MessageMapper.INSTANCE.toDTO(message));
    }
}
