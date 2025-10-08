package DesignPatterns.Creational.AbstractFactory.ui.solution;


public class WindowsButton implements Button {
    @Override
    public void paint() {
        System.out.println("Painting Windows Button");
    }
}
