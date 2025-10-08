package DesignPatterns.Behavioral.Command.textfile.invoker;

import DesignPatterns.Behavioral.Command.textfile.command.TextFileOperation;

import java.util.ArrayList;
import java.util.List;

public class TextFileOperationExecutor {

    private final List<TextFileOperation> textFileOperations = new ArrayList<>();

    public String executeOperation(TextFileOperation textFileOperation) {
        textFileOperations.add(textFileOperation);
        return textFileOperation.execute();
    }
}
