package DesignPatterns.Behavioral.Memento.Workflow;

import DesignPatterns.Behavioral.Memento.Workflow.command.AddStepCommand;
import DesignPatterns.Behavioral.Memento.Workflow.command.CreateCommand;
import DesignPatterns.Behavioral.Memento.Workflow.command.WorkflowCommand;

import java.util.LinkedList;

public class Client {

    public static void main(String[] args) {
        WorkflowDesigner designer = new WorkflowDesigner();
        LinkedList<WorkflowCommand> commands = runCommands(designer);
        designer.print();
        commands.removeLast().undo();
        designer.print();
        commands.removeLast().undo();
        designer.print();

        commands.removeLast().undo();
        designer.print();

        commands.removeLast().undo();
        designer.print();

    }

    private static void undoLastCommand(LinkedList<WorkflowCommand> commands) {
        if (!commands.isEmpty())
            commands.removeLast().undo();
    }

    private static LinkedList<WorkflowCommand> runCommands(WorkflowDesigner designer) {
        LinkedList<WorkflowCommand> commands = new LinkedList<>();

        WorkflowCommand cmd = new CreateCommand(designer, "Leave Workflow");
        commands.addLast(cmd);
        cmd.execute();
        // System.out.println("***************");

        cmd = new AddStepCommand(designer, "Create Leave Application");
        commands.addLast(cmd);
        cmd.execute();
        // System.out.println("***************");

        cmd = new AddStepCommand(designer, "Submit Application");
        commands.addLast(cmd);
        cmd.execute();
        // System.out.println("***************");

        cmd = new AddStepCommand(designer, "Application Approved");
        commands.addLast(cmd);
        cmd.execute();


        return commands;
    }
}
