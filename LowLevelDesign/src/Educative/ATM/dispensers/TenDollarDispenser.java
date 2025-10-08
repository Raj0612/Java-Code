package Educative.ATM.dispensers;

public class TenDollarDispenser extends CashDispenserHandler {
    private int count;

    public TenDollarDispenser(int count) {
        this.count = count;
    }

    @Override
    public void dispense(int amount) {
        int num = Math.min(amount / 10, count);
        if (num > 0) {
            System.out.println("Dispensing " + num + " $10 bills");
            count -= num;
            amount -= num * 10;
        }
        if (amount > 0 && nextHandler != null) {
            nextHandler.dispense(amount);
        } else if (amount > 0) {
            System.out.println("Cannot dispense remaining $" + amount);
        }
    }
}
