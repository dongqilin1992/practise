package com.smart.mq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: dongql
 * @date: 2018/9/13 10:34
 */
@Component
public class RabbitMqSender {
    @Autowired
    AmqpTemplate directTemplate;
    @Autowired
    AmqpTemplate topicTemplate;
    @Autowired
    AmqpTemplate fountTemplate;

    public boolean sendDirectMessage(String key, Object message) {
        boolean isFlag = false;
        directTemplate.convertAndSend(key, message);
        isFlag = true;
        return isFlag;
    }

    public boolean sendTopicMessage(String key, Object message) {
        boolean isFlag = false;
        topicTemplate.convertAndSend(key, message);
        isFlag = true;
        return isFlag;
    }
    public boolean sendFountMessage(String key, Object message) {
        boolean isFlag = false;
        fountTemplate.convertAndSend(key, message);
        isFlag = true;
        return isFlag;
    }
}
