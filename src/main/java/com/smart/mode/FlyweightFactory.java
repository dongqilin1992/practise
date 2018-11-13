package com.smart.mode;

import java.util.HashMap;

/**
 * @description:享元模式
 * @author: dongql
 * @date: 2018/4/2 15:26
 */
public class FlyweightFactory {
    private HashMap<Object,Flyweight> data;

    public FlyweightFactory(){ data = new HashMap<Object,Flyweight>();}

    public static void main(String[] args) {
        FlyweightFactory factory = new FlyweightFactory();
        Object o = new Object();
        factory.getFlyweight(o);
        factory.getFlyweight(o);
    }
    public Flyweight getFlyweight(Object object){
        if ( data.containsKey(object)){
            return data.get(object);
        }else {
            Flyweight flyweight = new Flyweight(object);
            data.put(object,flyweight);
            return flyweight;
        }
    }
}
abstract class flywei{ }

 class Flyweight extends flywei{
    Object obj ;
    public Flyweight(Object obj){
        this.obj = obj;
    }
}
