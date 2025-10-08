package DesignPatterns.Behavioral.Command.textfile.command;

import DesignPatterns.Behavioral.Command.textfile.receiver.TextFile;

public class OpenTextFileOperation  implements TextFileOperation {

    private final TextFile textFile;

    public OpenTextFileOperation(TextFile textFile) {
        this.textFile = textFile;
    }

    @Override
    public String execute() {
        return textFile.open();
    }
}
