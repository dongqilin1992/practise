package com.smart.mq;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: dongql
 * @date: 2018/9/14 11:26
 */
@Component
public class FountConsumerSso implements MessageListener {
    @Override
    public void onMessage(Message message) {
        System.out.println("FountConsumerSso收到消息：" + new String(message.getBody()));
    }
}