package DesignPatterns.Behavioral.Command.textfile;

import DesignPatterns.Behavioral.Command.textfile.command.OpenTextFileOperation;
import DesignPatterns.Behavioral.Command.textfile.command.SaveTextFileOperation;
import DesignPatterns.Behavioral.Command.textfile.command.TextFileOperation;
import DesignPatterns.Behavioral.Command.textfile.invoker.TextFileOperationExecutor;
import DesignPatterns.Behavioral.Command.textfile.receiver.TextFile;

public class Client {
    public static void main(String[] args) {

        TextFileOperation openTextFileOperation = new OpenTextFileOperation(new TextFile("file1.txt"));
        TextFileOperation saveTextFileOperation = new SaveTextFileOperation(new TextFile("file2.txt"));
        TextFileOperationExecutor textFileOperationExecutor = new TextFileOperationExecutor();
        System.out.println(textFileOperationExecutor.executeOperation(openTextFileOperation));
        System.out.println(textFileOperationExecutor.executeOperation(saveTextFileOperation));
    }
}
