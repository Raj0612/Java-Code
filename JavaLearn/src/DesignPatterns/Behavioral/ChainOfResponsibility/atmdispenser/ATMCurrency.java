package DesignPatterns.Behavioral.ChainOfResponsibility.atmdispenser;

public class ATMCurrency {
	private int amount;

	public ATMCurrency(int amt) {
		this.amount = amt;
	}

	public int getAmount() {
		return this.amount;
	}

}
