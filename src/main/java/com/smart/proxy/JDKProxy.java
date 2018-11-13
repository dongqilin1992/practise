package com.smart.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @description:
 * @author: dongql
 * @date: 2018/7/26 15:00
 */
public class JDKProxy {
    public static void main(String[] args) {
        //创建一个实例对象，这个对象是被代理的对象
        Person target = new Student("张三");
        //创建一个与代理对象相关联的InvocationHandler
        InvocationHandler stuHandler = new StudentInvocationHandler<Person>(target);
        //创建一个代理对象stuProxy来代理zhangsan，代理对象的每个执行方法都会替换执行Invocation中的invoke方法
        Person stuProxy = (Person) java.lang.reflect.Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), stuHandler);
        //代理执行上交班费的方法
        stuProxy.giveMoney();
        String money = stuProxy.getMoney();
        System.out.println(money);
    }

}

class StudentInvocationHandler<T> implements InvocationHandler {
    //invocationHandler持有的被代理对象
    T target;
    public StudentInvocationHandler(T target) {
        this.target = target;
    }

    /**
     * proxy:代表动态代理对象
     * method：代表正在执行的方法
     * args：代表调用目标方法时传入的实参
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("代理执行"+target.getClass().getName()+"." +method.getName() + "()方法");
        Object result = method.invoke(target, args);
        System.out.println("代理结束");
        return result;
    }
}
interface Person {
    //上交班费
    void giveMoney();
    String getMoney();
}
class Student implements Person {
    private String name;
    public Student(String name) {
        this.name = name;
    }

    @Override
    public void giveMoney() {
        System.out.println(name + "上交班费50元");
    }

    @Override
    public String getMoney() {
        String s = name + "已经上交班费50元";
        return s;
    }
}
