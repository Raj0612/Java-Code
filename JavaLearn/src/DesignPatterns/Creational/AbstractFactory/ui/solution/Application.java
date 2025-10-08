package DesignPatterns.Creational.AbstractFactory.ui.solution;

public class Application {
    private Button button;
    private Checkbox checkbox;

    public Application(UIAbstractFactory abstractFactory){
        button = abstractFactory.getButton();
        checkbox = abstractFactory.getCheckBox();
    }

    public void paint(){
        button.paint();
        checkbox.paint();
    }

}
