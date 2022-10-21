package com.nahorniak.secondconsumer.service;

import com.nahorniak.secondconsumer.config.AppConfig;
import com.nahorniak.secondconsumer.messages.CustomMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@Slf4j
public class MessageListenerService {
    @RabbitListener(queues = AppConfig.QUEUE)
    public void listen(CustomMessage message) {
        if (Objects.nonNull(message)){
            log.info("Message has been received from {} with header key {} : { date : {} ; message : {} }",
                    AppConfig.QUEUE,message.getHeaderKey(), message.getMessageDate(), message.getMessage());
        }
    }
}
