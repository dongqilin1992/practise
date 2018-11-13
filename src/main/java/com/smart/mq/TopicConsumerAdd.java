package com.smart.mq;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: dongql
 * @date: 2018/9/13 13:59
 */
@Component
public class TopicConsumerAdd implements MessageListener {
    @Override
    public void onMessage(Message message) {
        System.out.println("TopicConsumerAdd收到消息："+ new String (message.getBody()));
    }
}
