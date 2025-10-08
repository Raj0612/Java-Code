package DesignPatterns.Behavioral.Command.television;

public class Client {
    public static void main(String[] args) {

        //Receiver
        Television television = new Television();
        //Invoker
        TelevisionRemoteControl remote = new TelevisionRemoteControl();

        TelevisionCommand offCommand = new TelevisionOffCommand(television);
        TelevisionCommand onCommand = new TelevisionOnCommand(television);

        remote.setCommand(offCommand);
        remote.pressButton();
        remote.setCommand(onCommand);
        remote.pressButton();

//        remote.setOnCommand(onCommand);
//        remote.setOffCommand(offCommand);
    }
}
