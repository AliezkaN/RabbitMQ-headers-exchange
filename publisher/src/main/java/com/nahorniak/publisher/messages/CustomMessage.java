package com.nahorniak.publisher.messages;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CustomMessage {
    private String messageId;
    private String message;
    private String HeaderKey;
    private Date messageDate;
}
