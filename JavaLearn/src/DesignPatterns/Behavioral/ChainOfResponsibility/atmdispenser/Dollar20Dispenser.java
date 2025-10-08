package DesignPatterns.Behavioral.ChainOfResponsibility.atmdispenser;

public class Dollar20Dispenser implements ATMDispenseChain {

	private ATMDispenseChain chain;
	
	@Override
	public void setNextChain(ATMDispenseChain nextChain) {
		this.chain=nextChain;
	}

	@Override
	public void dispense(ATMCurrency cur) {
		if(cur.getAmount() >= 20){
			int num = cur.getAmount()/20;
			int remainder = cur.getAmount() % 20;
			System.out.println("Dispensing "+num+" 20$ note");
			if(remainder !=0) this.chain.dispense(new ATMCurrency(remainder));
		}else{
			this.chain.dispense(cur);
		}
	}

}