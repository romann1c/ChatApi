package com.romann1c.chatapi.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.romann1c.chatapi.dto.ChatMessageDto;
import org.springframework.stereotype.Service;


@Service
public class ChatMessageJsonService {

    private ObjectMapper mapper = new ObjectMapper();

    public String messageToJson(ChatMessageDto message) {
        try {
            return mapper.writeValueAsString(message);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "error";
        }
    }

    public ChatMessageDto jsonToMessage(String input) {

        try {
            ChatMessageDto chatMessageDto = mapper.readValue(input, ChatMessageDto.class);
            return chatMessageDto;
        } catch (JsonProcessingException e) {
            System.out.println("Exception while mapping to a pojo");
            return null;
        }
    }
}
