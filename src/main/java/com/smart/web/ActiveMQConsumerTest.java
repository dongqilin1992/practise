package com.smart.web;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @description:
 * @author: dongql
 * @date: 2017/10/26 9:09
 */
public class ActiveMQConsumerTest {
    public static void main(String[] args) {
        ConnectionFactory connectionFactory =
                new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_USER,
                        ActiveMQConnection.DEFAULT_PASSWORD,"failover://tcp://127.0.0.1:61616");
        try {
            Connection connection = connectionFactory.createConnection();
            connection.start();
            Session session=connection.createSession(Boolean.FALSE, Session.CLIENT_ACKNOWLEDGE);
            Destination destination = session.createQueue("queue");
            MessageConsumer messageProducer = session.createConsumer(destination);
            //TextMessage message = session.createTextMessage("nihao");
            TextMessage message= (TextMessage)messageProducer.receive();
            message.acknowledge();
            System.out.println("收到消息。。。。。。："+message.getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
