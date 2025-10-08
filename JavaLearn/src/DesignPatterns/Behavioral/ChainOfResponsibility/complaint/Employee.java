package DesignPatterns.Behavioral.ChainOfResponsibility.complaint;

public class Employee extends Complaint {
    public Employee(int level) {
        this.level = level;
    }

    @Override
    protected void handleComplaint(String complaint) {
        System.out.println("Employee is handling the complaint: " + complaint);
    }
}