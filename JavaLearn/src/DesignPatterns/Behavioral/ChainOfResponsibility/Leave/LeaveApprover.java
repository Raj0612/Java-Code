package DesignPatterns.Behavioral.ChainOfResponsibility.Leave;

//This represents a handler in chain of responsibility
public interface LeaveApprover {

	void processLeaveApplication(LeaveApplication application);
	
	String getApproverRole();
}
