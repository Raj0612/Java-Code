package DesignPatterns.Behavioral.ChainOfResponsibility.complaint;

public class Client {

    public static void main(String[] args) {
        Complaint c = chain();

        c.makeComplaint(Complaint.EMPLOYEE, "This complaint is directed to the employee.");
        c.makeComplaint(Complaint.AMANAGER, "This complaint is directed to the assistant manager.");
        c.makeComplaint(Complaint.MANAGER, "This complaint is directed to the manager.");
    }

    private static Complaint chain() {
        Complaint employee = new Employee(Complaint.EMPLOYEE);
        employee.setNextLevelComplaint(new AManager(Complaint.AMANAGER));
        employee.nextLevelComplaint.setNextLevelComplaint(new Manager(Complaint.MANAGER));
        return employee;
    }
}
