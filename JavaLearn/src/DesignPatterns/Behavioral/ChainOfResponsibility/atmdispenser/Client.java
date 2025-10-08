package DesignPatterns.Behavioral.ChainOfResponsibility.atmdispenser;

import java.util.Scanner;

public class Client {
	private ATMDispenseChain c1;

	public Client() {
		// initialize the chain
		this.c1 = new Dollar50Dispenser();
		ATMDispenseChain c2 = new Dollar20Dispenser();
		ATMDispenseChain c3 = new Dollar10Dispenser();

		// set the chain of responsibility
		c1.setNextChain(c2);
		c2.setNextChain(c3);

	}

	public static void main(String[] args) {
		Client atmDispenser = new Client();
		Scanner input = null;
		while (true) {
			int amount = 0;
			System.out.println("Enter amount to dispense");
			input = new Scanner(System.in);
			amount = input.nextInt();
			input.close();
			if (amount % 10 != 0) {
				System.out.println("Amount should be in multiple of 10s.");
				return;
			}
			// process the request
			atmDispenser.c1.dispense(new ATMCurrency(amount));
		}
	}
}
