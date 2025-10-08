package Educative.ATM.components;

import Educative.ATM.dispensers.CashDispenserHandler;
import Educative.ATM.dispensers.FiftyDollarDispenser;
import Educative.ATM.dispensers.HundredDollarDispenser;
import Educative.ATM.dispensers.TenDollarDispenser;

public class CashDispenser {

    private CashDispenserHandler  chain;
    public CashDispenser(int hundreds, int fifties, int tens) {
        // Build the chain
        CashDispenserHandler hundredHandler = new HundredDollarDispenser(hundreds);
        CashDispenserHandler fiftyHandler = new FiftyDollarDispenser(fifties);
        CashDispenserHandler tenHandler = new TenDollarDispenser(tens);

        hundredHandler.setNextHandler(fiftyHandler);
        fiftyHandler.setNextHandler(tenHandler);

        this.chain = hundredHandler;
    }

    public void dispenseCash(int amount) {
        chain.dispense(amount);
    }
}
