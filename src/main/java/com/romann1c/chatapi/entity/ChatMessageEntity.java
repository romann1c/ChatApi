package com.romann1c.chatapi.entity;

import com.romann1c.chatapi.dto.ChatMessageDto;
import com.romann1c.chatapi.util.LocalDateTimeFormatterUtil;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "messages")
@NoArgsConstructor
@Getter
public class ChatMessageEntity implements Comparable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "sender_id")
    private Integer senderID;


    @Column(name = "receiver_id")
    private Integer receiverID;


    @Column(name = "text")
    private String text;

    @Column(name = "local_date_time")
    private LocalDateTime localDateTime;

    public ChatMessageEntity(Integer senderID, Integer receiverID, String text, LocalDateTime localDateTime) {
        this.senderID = senderID;
        this.receiverID = receiverID;
        this.text = text;
        this.localDateTime = localDateTime;
    }

    public ChatMessageEntity(ChatMessageDto messageDto) {
        this.senderID = messageDto.getSenderID();
        this.receiverID = messageDto.getReceiverID();
        this.text = messageDto.getText();
        this.localDateTime = LocalDateTimeFormatterUtil.getLocalDateTimeFromJsonFormat(messageDto.getLocalDateTime());
    }

    @Override
    public String toString() {
        return senderID + " " + receiverID + " " + text + " " + localDateTime.toString();
    }


    @Override
    public int compareTo(Object o) {
        ChatMessageEntity entityForComparing = (ChatMessageEntity) o;
        return this.getLocalDateTime().compareTo(entityForComparing.getLocalDateTime());
    }
}
