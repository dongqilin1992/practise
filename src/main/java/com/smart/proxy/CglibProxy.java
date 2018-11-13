package com.smart.proxy;

import com.smart.service.UserService;
import com.smart.service.UserServiceImpl;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @description:
 * @author: dongql
 * @date: 2018/7/26 16:06
 */
public class CglibProxy implements MethodInterceptor {
    public static void main(String[] args) {
        CglibProxy cglibProxy = new CglibProxy();

        Enhancer enhancer = new Enhancer();  //主要的增强类
        enhancer.setSuperclass(UserServiceImpl.class);  //设置父类，被增强的类
        enhancer.setCallback(cglibProxy);  //回调对象

        UserService o = (UserService)enhancer.create();//用cglibProxy来增强UserServiceImpl
        o.findByName("");
        o.findUserById(1);
    }
    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("开始代理++++++before " + methodProxy.getSuperName() + "++++++");
        System.out.println(o.getClass().getName()+"."+method.getName());
        Object o1 = methodProxy.invokeSuper(o, args);
        System.out.println("结束代理++++++before " + methodProxy.getSuperName() + "++++++");
        return o1;
    }
}
