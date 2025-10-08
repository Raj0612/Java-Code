package DesignPatterns.Behavioral.Command.television;

public class TelevisionOffCommand implements TelevisionCommand{

    Television television;

    public TelevisionOffCommand (Television television){
        this.television = television;
    }
    @Override
    public void execute() {
        television.off();
    }
}
