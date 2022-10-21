package com.nahorniak.publisher.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    public static final String QUEUE1 = "myHeaderQueue1";
    public static final String QUEUE2 = "myHeaderQueue2";
    public static final String QUEUE3 = "myHeaderQueue3";

    public static final String KEY = "headerKey";

    public static final String HEADER_KEY1 = "firstQueue";
    public static final String HEADER_KEY2 = "secondQueue";
    public static final String HEADER_KEY3 = "thirdQueue";

    public static final String EXCHANGE = "header.exchange";


    @Bean
    public Queue myQueue1() {
        return  new Queue(QUEUE1);
    }

    @Bean Queue myQueue2(){ return  new Queue(QUEUE2);}

    @Bean Queue myQueue3(){ return  new Queue(QUEUE3);}

    @Bean
    public HeadersExchange exchange() {
        return new HeadersExchange(EXCHANGE);
    }

    @Bean
    public Binding binding1(Queue myQueue1, HeadersExchange exchange) {
        return BindingBuilder
                .bind(myQueue1)
                .to(exchange)
                .where(KEY)
                .matches(HEADER_KEY1);
    }

    @Bean
    public Binding binding2(Queue myQueue2, HeadersExchange exchange){
        return BindingBuilder
                .bind(myQueue2)
                .to(exchange)
                .where(KEY)
                .matches(HEADER_KEY2);
    }

    @Bean
    public Binding binding3(Queue myQueue3, HeadersExchange exchange){
        return BindingBuilder
                .bind(myQueue3)
                .to(exchange)
                .where(KEY)
                .matches(HEADER_KEY3);
    }

    @Bean
    public MessageConverter messageConverter() {
        return  new Jackson2JsonMessageConverter();
    }

    @Bean
    public AmqpTemplate template(ConnectionFactory connectionFactory) {
        RabbitTemplate template = new RabbitTemplate(connectionFactory);
        template.setMessageConverter(messageConverter());
        return  template;
    }

}
