package DesignPatterns.Behavioral.ChainOfResponsibility.complaint;

public abstract class Complaint {
    public static int EMPLOYEE = 1, AMANAGER = 2, MANAGER = 3;

    protected int level;

    public Complaint nextLevelComplaint;

    public void setNextLevelComplaint(Complaint nextLevelComplaint) {
        this.nextLevelComplaint = nextLevelComplaint;
    }

    public void makeComplaint(int level, String complaint) {
        if (this.level == level)
            handleComplaint(complaint);
        else if (nextLevelComplaint != null)
            nextLevelComplaint.makeComplaint(level, complaint);
    }

    protected abstract void handleComplaint(String complaint);
}