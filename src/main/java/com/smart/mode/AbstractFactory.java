package com.smart.mode;

/**
 * @description:抽象工厂模式
 * @author: dongql
 * @date: 2018/4/2 14:22
 */
public class AbstractFactory {
    public Food clientCode(String name) {
        Food x = null;
        if (name.equals("a")) {
            x = new FactoryForA().get();
        } else if(name.equals("b")){
            x = new FactoryForB().get();
        }
        return x;
    }

    public static void main(String[] args) {
        AbstractFactory factory = new AbstractFactory();
        Food food = factory.clientCode("a");
        System.out.println(food);
    }
}


interface Produce {
    Food get();
}

class FactoryForA implements Produce {
    @Override
    public Food get() {
        return new A();
    }
}

class FactoryForB implements Produce {
    @Override
    public Food get() {
        return new B();
    }
}
