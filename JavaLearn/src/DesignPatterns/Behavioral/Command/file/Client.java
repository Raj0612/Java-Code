package DesignPatterns.Behavioral.Command.file;

public class Client {

    public static void main(String[] args) {
        //Creating the receiver object
        FileSystemReceiver fs = FileSystemReceiverUtil.getUnderlyingFileSystem();

        //creating command and associating with receiver
        FileCommandOpen openFileCommand = new FileCommandOpen(fs);

        //Creating invoker and associating with Command
        FileInvoker file = new FileInvoker(openFileCommand);

        //perform action on invoker object
        file.execute();

        FileCommandWrite writeFileCommand = new FileCommandWrite(fs);
        file = new FileInvoker(writeFileCommand);
        file.execute();

        FileCommandClose closeFileCommand = new FileCommandClose(fs);
        file = new FileInvoker(closeFileCommand);
        file.execute();
    }
}
