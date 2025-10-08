package DesignPatterns.Creational.AbstractFactory.ui.problem;

public class WindowsCheckBox implements Checkbox{

    @Override
    public void paint() {
        System.out.println("Painting Windows CheckBox");
    }
}
