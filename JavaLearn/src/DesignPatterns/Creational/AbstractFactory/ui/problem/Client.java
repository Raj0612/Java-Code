package DesignPatterns.Creational.AbstractFactory.ui.problem;

public class Client {

    public static void main(String[] args) {
        Button button;
        Checkbox checkbox;

        String os = "Windows";

        if(os.equals("Windows")){
            button = new WindowsButton();
            checkbox = new WindowsCheckBox();
        }else{
            button = new MacButton();
            checkbox = new MacCheckBox();
        }

        button.paint();
        checkbox.paint();
    }
}
