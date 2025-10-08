package DesignPatterns.Creational.AbstractFactory.ui.solution;

public class MacFactory extends UIAbstractFactory{
    @Override
    Button getButton() {
        return new MacButton();
    }

    @Override
    Checkbox getCheckBox() {
        return new MacCheckBox();
    }
}
