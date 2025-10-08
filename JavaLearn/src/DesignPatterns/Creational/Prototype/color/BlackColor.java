package DesignPatterns.Creational.Prototype.color;

public class BlackColor extends Color {
    public BlackColor() {
        this.colorName = "black";
    }

    @Override
    public void addColor() {
        System.out.println(colorName + " color added");
    }
}
