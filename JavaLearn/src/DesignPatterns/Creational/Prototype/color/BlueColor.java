package DesignPatterns.Creational.Prototype.color;

public class BlueColor extends Color {
    public BlueColor() {
        this.colorName = "blue";
    }

    @Override
    public void addColor() {
        System.out.println(colorName + " color added");

    }
}
