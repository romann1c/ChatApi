package com.romann1c.chatapi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.romann1c.chatapi.entity.ChatMessageEntity;
import com.romann1c.chatapi.util.LocalDateTimeFormatterUtil;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;


@Data
public class ChatMessageDto implements Serializable {

    @JsonProperty("senderID")
    private Integer senderID;
    @JsonProperty("receiverID")
    private Integer receiverID;
    @JsonProperty("text")
    private String text;
    @JsonProperty("localDateTime")
    private String localDateTime;

    public ChatMessageDto(Integer senderID, Integer receiverID, String text) {
        this.senderID = senderID;
        this.receiverID = receiverID;
        this.text = text;
        this.localDateTime = LocalDateTimeFormatterUtil.localDateTimeToJsonFormat(LocalDateTime.now());
    }

    public ChatMessageDto(){
        this.localDateTime = LocalDateTimeFormatterUtil.localDateTimeToJsonFormat(LocalDateTime.now());
    }

    public ChatMessageDto(Integer senderID, Integer receiverID, String text, String localDateTime) {
        this.senderID = senderID;
        this.receiverID = receiverID;
        this.text = text;
        this.localDateTime = localDateTime;
    }
    public ChatMessageDto(ChatMessageEntity entity) {
        this.senderID = entity.getSenderID();
        this.receiverID = entity.getReceiverID();
        this.text = entity.getText();
        this.localDateTime = LocalDateTimeFormatterUtil.localDateTimeToJsonFormat(entity.getLocalDateTime());
    }
}