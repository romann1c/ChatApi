
package com.romann1c.chatapi.service;


import com.romann1c.chatapi.dto.ChatMessageDto;
import com.romann1c.chatapi.entity.ChatMessageEntity;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

@EnableRabbit
@ComponentScan
@Service
public class RabbitListenerService {

    private final ChatMessageEntityService entityService;

    @Autowired
    public RabbitListenerService(ChatMessageEntityService entityService) {
        this.entityService = entityService;
    }

    @RabbitListener(queues = "messageQueue")
    public void processMyQueue(ChatMessageDto message){
        entityService.save(new ChatMessageEntity(message));
    }
}
