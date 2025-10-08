package DesignPatterns.Behavioral.ChainOfResponsibility.Leave;

import DesignPatterns.Behavioral.ChainOfResponsibility.Leave.LeaveApplication.Type;
//A concrete handler
public class Director extends Employee {

	public Director(LeaveApprover nextApprover) {
		super("Director", nextApprover);
	}
	
	@Override
	protected boolean processRequest(LeaveApplication application) {
		System.out.println("Director processRequest ");
		if(application.getType() == Type.PTO) {
			application.approve(getApproverRole());
			return true;
		}
		return false;
	}
	
}
