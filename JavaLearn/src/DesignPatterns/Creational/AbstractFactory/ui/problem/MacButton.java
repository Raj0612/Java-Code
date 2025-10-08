package DesignPatterns.Creational.AbstractFactory.ui.problem;

public class MacButton implements Button{
    @Override
    public void paint() {
        System.out.println("Painting Mac Button");
    }
}
