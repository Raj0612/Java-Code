package DesignPatterns.Behavioral.Command.television;

public class TelevisionRemoteControl {

    TelevisionCommand command;
    TelevisionCommand onCommand;
    TelevisionCommand offCommand;
    public TelevisionCommand getCommand() {
        return command;
    }

    public void setCommand(TelevisionCommand command) {
        this.command = command;
    }
    public void pressButton(){
        command.execute();
    }

    public void setOnCommand(TelevisionCommand onCommand) {
        this.onCommand = onCommand;
    }

    public void setOffCommand(TelevisionCommand offCommand) {
        this.offCommand = offCommand;
    }

}
