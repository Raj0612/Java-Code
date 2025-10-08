package DesignPatterns.Structural.Decorator.shape;

public abstract class ShapeDecorator implements Shape {
    protected Shape decoratedShape;

    public ShapeDecorator(Shape decoratedShape)  {
        this.decoratedShape = decoratedShape;
    }

    public void draw() {
        System.out.println("ShapeDecorator draw");
        decoratedShape.draw();
    }
}
