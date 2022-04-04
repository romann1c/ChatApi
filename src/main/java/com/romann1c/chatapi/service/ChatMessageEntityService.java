package com.romann1c.chatapi.service;

import com.romann1c.chatapi.entity.ChatMessageEntity;
import com.romann1c.chatapi.repository.ChatMessageEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class ChatMessageEntityService {

    private final ChatMessageEntityRepository repository;

    @Autowired
    public ChatMessageEntityService(ChatMessageEntityRepository repository) {
        this.repository = repository;
    }

    public void save(ChatMessageEntity entity){
        repository.save(entity);
    }

    public List<ChatMessageEntity> getAllMessagesOf(Integer senderID, Integer receiverID){
        List<ChatMessageEntity> list = repository.findAllBySenderIDAndReceiverID(senderID, receiverID);
        list.addAll(repository.findAllBySenderIDAndReceiverID(receiverID, senderID));
        return list;
    }

}
