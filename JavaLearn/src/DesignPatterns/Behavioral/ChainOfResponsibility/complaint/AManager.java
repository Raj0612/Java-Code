package DesignPatterns.Behavioral.ChainOfResponsibility.complaint;

public class AManager extends Complaint {
    public AManager(int level) {
        this.level = level;
    }

    @Override
    protected void handleComplaint(String complaint) {
        System.out.println("Assistant manager is handling the complaint: " + complaint);
    }
}