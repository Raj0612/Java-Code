package DesignPatterns.Behavioral.Memento.Workflow.command;


import DesignPatterns.Behavioral.Memento.Workflow.WorkflowDesigner;

public class AddStepCommand extends AbstractWorkflowCommand {

    public AddStepCommand(WorkflowDesigner designer, String step) {
        super(designer);
        System.out.print("AddStepCommand step " + step + " : ");
        this.step = step;
    }

    @Override
    public void execute() {
        this.memento = receiver.getMemento();
        receiver.addStep(step);
    }
}
