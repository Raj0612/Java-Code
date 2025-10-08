package DesignPatterns.Behavioral.Command.textfile.command;

import DesignPatterns.Behavioral.Command.textfile.receiver.TextFile;

public class SaveTextFileOperation implements TextFileOperation {

    private final TextFile textFile;

    public SaveTextFileOperation(TextFile textFile) {
        this.textFile = textFile;
    }

    @Override
    public String execute() {
        return textFile.save();
    }
}
