package DesignPatterns.Structural.Facade.shape;

public class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("Square::draw()");
    }
}
