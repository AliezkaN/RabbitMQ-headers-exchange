package com.nahorniak.consumer.service;

import com.nahorniak.consumer.config.AppConfig;
import com.nahorniak.consumer.messages.CustomMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@Slf4j
public class MessageListenerService {

    @RabbitListener(queues = AppConfig.QUEUE1)
    public void listenFirstQueue(CustomMessage message) {
        logMessage(AppConfig.QUEUE1,message);
    }

    @RabbitListener(queues = AppConfig.QUEUE2)
    public void listenSecondQueue(CustomMessage message) {
        logMessage(AppConfig.QUEUE2,message);
    }

    private void logMessage(String queue, CustomMessage message){
        if (Objects.nonNull(message)){
            log.info("Message has been received from {} with header key {} : { date : {} ; message : {} }",
                    queue,message.getHeaderKey(), message.getMessageDate(), message.getMessage());
        }
    }
}

