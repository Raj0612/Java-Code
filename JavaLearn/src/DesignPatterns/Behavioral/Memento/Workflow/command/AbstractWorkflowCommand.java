package DesignPatterns.Behavioral.Memento.Workflow.command;


import DesignPatterns.Behavioral.Memento.Workflow.WorkflowDesigner;

public abstract class AbstractWorkflowCommand implements WorkflowCommand {

    protected WorkflowDesigner.Memento memento;

    protected WorkflowDesigner receiver;

    protected String step;

    public AbstractWorkflowCommand(WorkflowDesigner designer) {
        this.receiver = designer;
    }

    @Override
    public void undo() {
        System.out.println("undo " + memento.name + " name " + step);
        receiver.setMemento(memento);
    }

}
