package DesignPatterns.Behavioral.Command.television;

public class TelevisionOnCommand implements TelevisionCommand{
    Television television;

    public TelevisionOnCommand (Television television){
        this.television = television;
    }
    @Override
    public void execute() {
        television.on();
    }
}
