package com.nahorniak.publisher.service;

import com.nahorniak.publisher.config.AppConfig;
import com.nahorniak.publisher.messages.CustomMessage;
import lombok.AllArgsConstructor;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.amqp.support.converter.SimpleMessageConverter;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
@AllArgsConstructor
public class MessagePublisherService {

    private final RabbitTemplate template;
    private final MessageConverter converter;

    public void send(CustomMessage customMessage){
        customMessage.setMessageId(UUID.randomUUID().toString());
        customMessage.setMessageDate(new Date());

        MessageProperties msgProperties = new MessageProperties();
        msgProperties.setHeader(AppConfig.KEY, customMessage.getHeaderKey());
        Message message = converter.toMessage(customMessage,msgProperties);

        template.convertAndSend(AppConfig.EXCHANGE,"",message);
    }
}
