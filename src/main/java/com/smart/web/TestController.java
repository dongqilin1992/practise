package com.smart.web;

import com.smart.mq.RabbitMqSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @description:
 * @author: dongql
 * @date: 2018/3/29 15:03
 */
@Controller
public class TestController {

    @Autowired
    RabbitMqSender rabbitMqSender;
    @RequestMapping("/mq/topic/{type}")
    public String sendTop(@PathVariable String type) {
        boolean b = rabbitMqSender.sendTopicMessage("topic." + type, "nihao");
        System.out.println("发送topic消息:你好" + b);
        return null;
    }
    @RequestMapping("/mq/direct/{type}")
    public String sendDirect(@PathVariable String type) {
        boolean b = rabbitMqSender.sendDirectMessage("direct." + type, "nihao");
        System.out.println("发送direct消息:你好" + b);
        return null;
    }
    @RequestMapping("/mq/fount/{type}")
    public String sendFount(@PathVariable String type) {
        boolean b = rabbitMqSender.sendFountMessage("fount." + type, "nihao");
        System.out.println("发送fount消息:你好" + b);
        return null;
    }
}
