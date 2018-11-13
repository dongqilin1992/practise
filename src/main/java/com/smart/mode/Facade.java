package com.smart.mode;

/**
 * @description:
 * @author: dongql
 * @date: 2018/4/2 17:30
 */
public class Facade {
    private Shapes circle;
    private Shapes rectangle;
    private Shapes square;
    public static void main(String[] args) {
        Facade shapeMaker = new Facade();

        shapeMaker.drawCircle();
        shapeMaker.drawRectangle();
        shapeMaker.drawSquare();
    }
    public Facade() {
        circle = new Circles();
        rectangle = new Rectangle();
        square = new Square();
    }

    public void drawCircle(){
        circle.draw();
    }
    public void drawRectangle(){
        rectangle.draw();
    }
    public void drawSquare(){
        square.draw();
    }
}
interface Shapes {
    void draw();
}
 class Rectangle implements Shapes {

    @Override
    public void draw() {
        System.out.println("Rectangle::draw()");
    }
}
class Square implements Shapes {

    @Override
    public void draw() {
        System.out.println("Square::draw()");
    }
}
class Circles implements Shapes {

    @Override
    public void draw() {
        System.out.println("Circle::draw()");
    }
}