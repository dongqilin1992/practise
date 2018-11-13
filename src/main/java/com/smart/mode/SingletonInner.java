package com.smart.mode;

/**
 * @description:
 * @author: dongql
 * @date: 2018/4/2 15:37
 */
public class SingletonInner {
    public static void main(String[] args) {
        SingletonInner instance = SingletonInner.getInstance();
        System.out.println(instance);
        SingletonInner instance2 = SingletonInner.getInstance();
        System.out.println(instance2);
    }
    /**
     * 内部类实现单例模式
     * 延迟加载，减少内存开销
     */
    private static class SingletonHolder {
        private static SingletonInner instance = new SingletonInner();
    }

    /**
     * 私有的构造函数
     */
    private SingletonInner() {}

    public static SingletonInner getInstance() {
        return SingletonHolder.instance;
    }
}
