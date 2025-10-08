package DesignPatterns.Behavioral.Memento.Workflow.command;

public interface WorkflowCommand {

    void execute();

    void undo();
}
