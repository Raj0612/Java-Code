package DesignPatterns.Behavioral.ChainOfResponsibility.atmdispenser;

public interface ATMDispenseChain {

	void setNextChain(ATMDispenseChain nextChain);
	
	void dispense(ATMCurrency cur);
}