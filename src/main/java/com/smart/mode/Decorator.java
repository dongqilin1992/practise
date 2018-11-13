package com.smart.mode;

/**
 * @description:装饰器模式
 * @author: dongql
 * @date: 2018/4/2 16:46
 */
public class Decorator implements Component{
    public static void main(String[] args) {
        Person mPerson = new Person("Andy");
        Jeans mJeans = new Jeans();
        TShirt mShirt = new TShirt();
        mShirt.decoratorObj(mPerson);
        mJeans.decoratorObj(mShirt);
        mJeans.show();
    }
    private Component mComponent;
    public void decoratorObj(Component component){
        mComponent = component;
    }

    @Override
    public void show() {
        if(mComponent != null){
            mComponent.show();
        }
    }
}
 interface Component {
    void show();
}
 class Person implements Component{
    private String name;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person(String name){
        this.name = name;
    }

    @Override
    public void show() {
        System.out.println("装扮的" + name);
    }
}
class Jeans extends Decorator {
    @Override
    public void show(){
        System.out.println("穿牛仔裤");
        super.show();
    }

}
class TShirt  extends Decorator {
    @Override
    public void show(){
        System.out.println("穿T-Shirt");
        super.show();
    }

}