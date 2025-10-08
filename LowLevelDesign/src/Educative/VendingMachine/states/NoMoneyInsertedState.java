package Educative.VendingMachine.states;

import Educative.VendingMachine.VendingMachine;

public class NoMoneyInsertedState implements State {
    @Override
    public void insertMoney(VendingMachine machine, double amount) {
        machine.addAmount(amount);
        System.out.println("[NoMoneyInsertedState] Inserted ₹" + amount
                + ". Current balance: ₹" + machine.getAmount());
        machine.setCurrentState(new MoneyInsertedState());
        System.out.println("[NoMoneyInsertedState] Transitioning to MoneyInsertedState.");
    }

    @Override
    public void pressButton(VendingMachine machine, int rackNumber) {
        System.out.println("[NoMoneyInsertedState] Cannot select rack " + rackNumber
                + ". Please insert money first.");
    }

    @Override
    public void returnChange(VendingMachine machine) {
        System.out.println("[NoMoneyInsertedState] No money to return.");
    }

    @Override
    public void updateInventory(VendingMachine machine, int rackNumber) {
        System.out.println("[NoMoneyInsertedState] Inventory update allowed by admin only, not in this state.");
    }

    @Override
    public void dispenseProduct(VendingMachine machine, int rackNumber) {
        System.out.println("[NoMoneyInsertedState] Cannot dispense product without payment.");
    }
}
