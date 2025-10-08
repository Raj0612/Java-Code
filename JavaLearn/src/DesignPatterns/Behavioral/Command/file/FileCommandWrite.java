package DesignPatterns.Behavioral.Command.file;

public class FileCommandWrite implements FileCommand {

    private FileSystemReceiver fileSystem;

    public FileCommandWrite(FileSystemReceiver fs){
        this.fileSystem=fs;
    }
    @Override
    public void execute() {
        this.fileSystem.writeFile();
    }

}
