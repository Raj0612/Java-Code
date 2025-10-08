package DesignPatterns.Behavioral.Memento.Workflow.command;


import DesignPatterns.Behavioral.Memento.Workflow.WorkflowDesigner;

public class RemoveStepCommand extends AbstractWorkflowCommand {


    public RemoveStepCommand(WorkflowDesigner designer, String step) {
        super(designer);
        this.step = step;
    }

    @Override
    public void execute() {
        memento = receiver.getMemento();
        receiver.removeStep(step);
    }
}
