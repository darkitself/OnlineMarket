package com.study.onlinemarket.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.experimental.FieldDefaults;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;


@Service("rabbitService")
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class RabbitService {

    ObjectMapper objectMapper;
    RabbitTemplate rabbitTemplate;

    @SneakyThrows
    public void send(Object message) {

        MessageProperties messageProperties = new MessageProperties();

        messageProperties.setContentType(MessageProperties.CONTENT_TYPE_JSON);

        Message msg = new Message(objectMapper.writeValueAsBytes(message), messageProperties);

        rabbitTemplate.send("test.queue", msg);

        System.out.println("Message sent!!!!");
    }
}