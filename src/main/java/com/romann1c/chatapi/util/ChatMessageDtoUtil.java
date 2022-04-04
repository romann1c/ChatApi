package com.romann1c.chatapi.util;

import com.romann1c.chatapi.dto.ChatMessageDto;
import com.romann1c.chatapi.entity.ChatMessageEntity;
import org.springframework.context.annotation.ComponentScan;

import java.util.ArrayList;
import java.util.List;

@ComponentScan
public class ChatMessageDtoUtil {

    public static List<ChatMessageDto> listMessagesDtoFromEntity(List<ChatMessageEntity> entityList){
        List<ChatMessageDto> list = new ArrayList<>();
        entityList.stream().forEach(entity -> {
            list.add(new ChatMessageDto(entity));
        });
        return list;
    }
}
