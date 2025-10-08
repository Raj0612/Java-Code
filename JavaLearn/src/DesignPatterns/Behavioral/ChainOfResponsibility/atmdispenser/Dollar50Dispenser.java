package DesignPatterns.Behavioral.ChainOfResponsibility.atmdispenser;

public class Dollar50Dispenser implements ATMDispenseChain {

	private ATMDispenseChain chain;
	
	@Override
	public void setNextChain(ATMDispenseChain nextChain) {
		this.chain=nextChain;
	}

	@Override
	public void dispense(ATMCurrency cur) {
		if(cur.getAmount() >= 50){
			int num = cur.getAmount()/50;
			int remainder = cur.getAmount() % 50;
			System.out.println("Dispensing "+num+" 50$ note");
			if(remainder !=0) this.chain.dispense(new ATMCurrency(remainder));
		}else{
			this.chain.dispense(cur);
		}
	}

}