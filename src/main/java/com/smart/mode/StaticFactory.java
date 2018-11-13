package com.smart.mode;

/**
 * @description: 静态工厂方法模式，静态工厂模式在不改动StaticFactory类的代码时无法新增产品
 * @author: dongql
 * @date: 2018/4/2 14:19
 */
public class StaticFactory {
    private StaticFactory(){}

    public static Food getA(){  return new A(); }
    public static Food getB(){  return new B(); }
    public static Food getC(){  return new C(); }

    public static void main(String[] args) {
        Client client = new Client();
        Food food = client.get("A");
        System.out.println(food);
    }
}
interface Food{}

class A implements Food{}
class B implements Food{}
class C implements Food{}

class Client{
    //客户端代码只需要将相应的参数传入即可得到对象
    //用户不需要了解工厂类内部的逻辑。
    public Food get(String name){
        Food x = null ;
        if ( name.equals("A")) {
            x = StaticFactory.getA();
        }else if ( name.equals("B")){
            x = StaticFactory.getB();
        }else {
            x = StaticFactory.getC();
        }
        return x;
    }
}
