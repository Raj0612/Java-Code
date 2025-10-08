package DesignPatterns.Structural.Bridge.color;

public class Client {

    public static void main(String[] args) {
        Shape square = new Square(new Blue());
        System.out.println(" " + square.draw());
    }
}
