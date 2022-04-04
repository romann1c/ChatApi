package com.romann1c.chatapi.service;

import com.romann1c.chatapi.dto.ChatMessageDto;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RabbitProducerService {

    private final RabbitTemplate template;

    @Autowired
    public RabbitProducerService(RabbitTemplate template) {
        this.template = template;
    }

    public void sendToMessageQueue(ChatMessageDto message){
        template.convertAndSend("messageQueue", message);
    }

}

