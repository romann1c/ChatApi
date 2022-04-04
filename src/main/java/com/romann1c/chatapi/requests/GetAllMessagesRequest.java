package com.romann1c.chatapi.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@AllArgsConstructor
@ComponentScan
@Component
@Getter
public class GetAllMessagesRequest {
    private Integer senderID;
    private Integer receiverID;
}
