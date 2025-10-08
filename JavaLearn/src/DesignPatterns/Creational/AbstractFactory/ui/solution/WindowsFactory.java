package DesignPatterns.Creational.AbstractFactory.ui.solution;
public class WindowsFactory extends UIAbstractFactory{
    @Override
    Button getButton() {
        return new WindowsButton();
    }

    @Override
    Checkbox getCheckBox() {
        return new WindowsCheckBox();
    }
}
