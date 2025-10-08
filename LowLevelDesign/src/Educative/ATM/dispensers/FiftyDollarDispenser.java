package Educative.ATM.dispensers;

public class FiftyDollarDispenser extends CashDispenserHandler {
    private int count;

    public FiftyDollarDispenser(int count) {
        this.count = count;
    }

    @Override
    public void dispense(int amount) {
        int num = Math.min(amount / 50, count);
        if (num > 0) {
            System.out.println("Dispensing " + num + " $50 bills");
            count -= num;
            amount -= num * 50;
        }
        if (amount > 0 && nextHandler != null) {
            nextHandler.dispense(amount);
        } else if (amount > 0) {
            System.out.println("Cannot dispense remaining $" + amount);
        }
    }
}
