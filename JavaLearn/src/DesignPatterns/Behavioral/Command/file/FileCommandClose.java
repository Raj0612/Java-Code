package DesignPatterns.Behavioral.Command.file;

public class FileCommandClose implements FileCommand {

    private FileSystemReceiver fileSystem;

    public FileCommandClose(FileSystemReceiver fs){
        this.fileSystem=fs;
    }
    @Override
    public void execute() {
        this.fileSystem.closeFile();
    }

}
