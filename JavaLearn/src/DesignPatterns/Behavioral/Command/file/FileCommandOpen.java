package DesignPatterns.Behavioral.Command.file;

public class FileCommandOpen implements FileCommand {

    private FileSystemReceiver fileSystem;

    public FileCommandOpen(FileSystemReceiver fs){
        this.fileSystem=fs;
    }
    @Override
    public void execute() {
        //open command is forwarding request to openFile method
        this.fileSystem.openFile();
    }

}
