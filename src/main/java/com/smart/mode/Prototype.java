package com.smart.mode;

/**
 * @description:原型
 * @author: dongql
 * @date: 2018/4/2 14:53
 */
public class Prototype implements Cloneable {
    public static void main(String[] args) {
        Prototype pro = new Prototype();
        Prototype pro1 = (Prototype) pro.clone();
        System.out.println(pro1);
        Prototype pro2 = (Prototype) pro.clone();
        System.out.println(pro2);
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    protected Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        } finally {
            //return null;
        }
        return null;
    }


}
