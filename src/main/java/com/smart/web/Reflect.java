package com.smart.web;

import com.smart.domain.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @description:
 * @author: dongql
 * @date: 2017/10/10 11:35
 */
public class Reflect {

    public static void main(String[] args) throws Exception{
        reflects();
    }

    public static void reflects() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class clazz = Class.forName("com.smart.domain.User");
        //Constructor constructor = clazz.getDeclaredConstructor((Class[])null);
       User user = (User)clazz.newInstance();

        Method method= clazz.getMethod("setUserName",String.class);
        method.invoke(user,"dddd");

        //String name = user.getUserName();
        //System.out.println(name);
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext();
    }
}
