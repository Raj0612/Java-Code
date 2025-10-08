package DesignPatterns.Structural.Decorator.shape;

public class RedShapeDecorator extends ShapeDecorator {

    public RedShapeDecorator(Shape decoratedShape) {
        super(decoratedShape);
    }

    @Override
    public void draw() {
        System.out.println("RedShapeDecorator draw");
        decoratedShape.draw();
        setRedBorder(decoratedShape);
    }

    private void setRedBorder(Shape decoratedShape) {

        System.out.println("Border Color: Red");
    }
}
