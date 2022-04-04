package com.romann1c.chatapi.controller;


import com.romann1c.chatapi.dto.ChatMessageDto;
import com.romann1c.chatapi.requests.GetAllMessagesRequest;
import com.romann1c.chatapi.util.ChatMessageDtoUtil;
import com.romann1c.chatapi.service.ChatMessageJsonService;
import com.romann1c.chatapi.service.ChatMessageEntityService;
import com.romann1c.chatapi.service.RabbitProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@ComponentScan
public class ChatRestController {

    private final RabbitProducerService rabbitProducer;

    private final ChatMessageJsonService messageJsonService;

    private final ChatMessageEntityService entityService;

    @Autowired
    public ChatRestController(RabbitProducerService rabbitProducer, ChatMessageJsonService messageJsonService, ChatMessageEntityService entityService) {

        this.rabbitProducer = rabbitProducer;
        this.messageJsonService = messageJsonService;
        this.entityService = entityService;

    }

    @PostMapping("/post-message")
    public void postMessage(@RequestBody ChatMessageDto message) {
        rabbitProducer.sendToMessageQueue(message);
    }

    @PostMapping("/get-messages-in-chat")
    @ResponseBody
    public List<ChatMessageDto> getChatMessages(@RequestBody GetAllMessagesRequest request) {
        if(request.getSenderID() == null || request.getReceiverID() == null) return null;
        return ChatMessageDtoUtil.listMessagesDtoFromEntity(entityService.getAllMessagesOf(request.getSenderID(), request.getReceiverID()));
    }
}
