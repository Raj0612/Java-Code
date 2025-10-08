package Educative.VendingMachine.states;

import Educative.VendingMachine.VendingMachine;
import Educative.VendingMachine.subjects.Product;
import Educative.VendingMachine.subjects.Rack;

public class MoneyInsertedState implements State {
    @Override
    public void insertMoney(VendingMachine machine, double amount) {
        machine.addAmount(amount);
        System.out.println("[MoneyInsertedState] Added ₹" + amount
                + ". Total balance: ₹" + machine.getAmount());
    }

    @Override
    public void pressButton(VendingMachine machine, int rackNumber) {
        System.out.println("[MoneyInsertedState] Button pressed for rack " + rackNumber);

        Rack rack = machine.getInventory().getRack(rackNumber);

        if (rack == null || rack.isEmpty()) {
            System.out.println("[MoneyInsertedState] Product not available at rack " + rackNumber);
            machine.setCurrentState(new NoMoneyInsertedState());
            return;
        }

        Product product = rack.peekProduct();
        if (machine.getAmount() < product.getPrice()) {
            System.out.println("[MoneyInsertedState] Insufficient balance. "
                    + "Price: ₹" + product.getPrice()
                    + ", Current Balance: ₹" + machine.getAmount());
            return;
        }

        System.out.println("[MoneyInsertedState] Product selected: " + product.getName()
                + " (₹" + product.getPrice() + ")");
        machine.setCurrentState(new DispenseState());
        machine.dispenseProduct(rackNumber);
    }

    @Override
    public void returnChange(VendingMachine machine) {
        if (machine.getAmount() > 0) {
            System.out.println("[MoneyInsertedState] Returning ₹" + machine.getAmount());
            machine.resetAmount();
        } else {
            System.out.println("[MoneyInsertedState] No balance to return.");
        }
        machine.setCurrentState(new NoMoneyInsertedState());
        System.out.println("[MoneyInsertedState] Transitioning back to NoMoneyInsertedState.");
    }

    @Override
    public void updateInventory(VendingMachine machine, int rackNumber) {
        System.out.println("[MoneyInsertedState] Cannot update inventory while money is inserted.");
    }

    @Override
    public void dispenseProduct(VendingMachine machine, int rackNumber) {
        System.out.println("[MoneyInsertedState] Cannot dispense directly. Press a button instead.");
    }
}
