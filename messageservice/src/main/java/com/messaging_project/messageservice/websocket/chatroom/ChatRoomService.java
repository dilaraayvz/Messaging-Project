package com.messaging_project.messageservice.websocket.chatroom;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ChatRoomService {
    private final ChatRoomRepository chatRoomRepository;
    public Optional<String> getChatRoomId(int senderId, int recipientId, boolean createNewRoomIfNotExist){
        return chatRoomRepository.findBySenderIdAndRecipientId(senderId,recipientId)
                .map(ChatRoom::getChatId)
                .or(()->{
                    if(createNewRoomIfNotExist){
                        var chatId=createChatId(senderId,recipientId);
                        return Optional.of(chatId);
                    }
                    return Optional.empty();
                });
    }

    private String createChatId(int senderId, int recipientId) {
        var chatId=String.format("%s_%s",senderId,recipientId);
        ChatRoom senderRecipient=ChatRoom.builder()
                .chatId(chatId)
                .senderId(senderId)
                .recipientId(recipientId)
                .build();


        ChatRoom recipientSender=ChatRoom.builder()
                .chatId(chatId)
                .senderId(recipientId)
                .recipientId(senderId)
                .build();
        chatRoomRepository.save(senderRecipient);
        chatRoomRepository.save(recipientSender);
        return chatId;
    }

}
