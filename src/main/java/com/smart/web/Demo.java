package com.smart.web;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: dongql
 * @date: 2017/10/13 17:40
 */
@RestController
//@EnableAutoConfiguration
public class Demo {
    @RequestMapping("/")
    String home() {
        return "Hello World!";
    }

    @RequestMapping("/hello/{myName}")
    String index(@PathVariable
                         String myName) {
        return "Hello "+myName+"!!!";
    }
}
