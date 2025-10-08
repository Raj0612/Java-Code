package DesignPatterns.Structural.Bridge.color;

public abstract class Shape {

    protected Color color;

    protected Shape(Color color) {
        this.color = color;
    }
    abstract public String draw();
}
