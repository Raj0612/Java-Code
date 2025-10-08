package DesignPatterns.Behavioral.Command.file;

public class FileInvoker {
    public FileCommand command;

    public FileInvoker(FileCommand c){
        this.command=c;
    }

    public void execute(){
        this.command.execute();
    }
}
