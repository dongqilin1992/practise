package com.smart.mode;

/**
 * @description:代理模式最主要的就是有一个公共接口（Image），一个具体的类（RealImage），一个代理类（ProxyImage）,代理类持有具体类的实例，代为执行具体类实例方法
 * @author: dongql
 * @date: 2018/4/2 17:34
 */
public class Proxy {
    public static void main(String[] args) {
        RealImage realImage = new RealImage("a.jgp");
        Image image = new ProxyImage(realImage);
        //图像将从磁盘加载
        image.display();
    }
}
 interface Image {
    void display();
}
class RealImage implements Image {

    private String fileName;

    public RealImage(String fileName){
        this.fileName = fileName;
        loadFromDisk(fileName);
    }

    @Override
    public void display() {
        System.out.println("Displaying " + fileName);
    }

    private void loadFromDisk(String fileName){
        System.out.println("Loading ..." + fileName);
    }
}
class ProxyImage implements Image{

    private RealImage realImage;

    public ProxyImage(Image image){
        this.realImage = (RealImage)image;
    }

    @Override
    public void display() {
        System.out.println("开始代理。。。");
        realImage.display();
        System.out.println("结束代理。。。");
    }
}