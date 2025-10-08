package DesignPatterns.Structural.Facade.shape;

public class ShapeMaker {
    private Shape circle;
    private Shape rectangle;
    private Shape square;

    public ShapeMaker() {
        circle = (Shape) new Circle();
        rectangle = (Shape) new Rectangle();
        square = (Shape) new Square();
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
