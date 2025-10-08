package com.designpattern;


interface Command{
    void execute();
}

class Light{
    private boolean on;

    public void switchOn(){
        on = true;
    }

    public void switchOff(){
        on = false;
    }

}

class LightOffCommand implements Command{
    private final Light light;

    LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        System.out.println("Switching off Light ...");
        light.switchOff();
    }
}

class LightOnCommand implements Command{
    private final Light light;

    LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        System.out.println("Switching on Light ...");
        light.switchOn();
    }
}
class SwitchControl{
    private Command command;

    SwitchControl(){

    }
    public void setCommand(Command command){
        this.command = command;
    }

    public void pressButton(){
        command.execute();
    }

}
public class CommandMain {
    public static void main(String[] args) {
        Light light = new Light();
        SwitchControl switchControl = new SwitchControl();
        Command lightsOn = new LightOnCommand(light);
        Command lightsOff = new LightOffCommand(light);
        switchControl.setCommand(lightsOn);
        switchControl.pressButton();

        switchControl.setCommand(lightsOff);
        switchControl.pressButton();

    }
}
