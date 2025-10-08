package DesignPatterns.Behavioral.ChainOfResponsibility.complaint;

public class Manager extends Complaint {
    public Manager(int level) {
        this.level = level;
    }

    @Override
    protected void handleComplaint(String complaint) {
        System.out.println("Manager is handling the complaint: " + complaint);
    }
}