package Educative.VendingMachine.states;

import Educative.VendingMachine.VendingMachine;
import Educative.VendingMachine.subjects.Product;
import Educative.VendingMachine.subjects.Rack;

public class DispenseState implements State {
    @Override
    public void insertMoney(VendingMachine machine, double amount) {
        System.out.println("[DispenseState] Cannot insert money while dispensing product.");
    }

    @Override
    public void pressButton(VendingMachine machine, int rackNumber) {
        System.out.println("[DispenseState] Button press ignored. Product is already being dispensed.");
    }

    @Override
    public void returnChange(VendingMachine machine) {
        if (machine.getAmount() > 0) {
            System.out.println("[DispenseState] Returning ₹" + machine.getAmount());
            machine.resetAmount();
        } else {
            System.out.println("[DispenseState] No change to return.");
        }
    }

    @Override
    public void updateInventory(VendingMachine machine, int rackNumber) {
        System.out.println("[DispenseState] Inventory update is not allowed during dispensing.");
    }

    @Override
    public void dispenseProduct(VendingMachine machine, int rackNumber) {
        System.out.println("[DispenseState] Preparing to dispense from rack " + rackNumber + "...");

        Rack rack = machine.getInventory().getRack(rackNumber);
        if (rack == null || rack.isEmpty()) {
            System.out.println("[DispenseState] Rack is empty. Cannot dispense.");
            machine.setCurrentState(new NoMoneyInsertedState());
            return;
        }

        Product product = rack.removeProduct();
        if (product != null) {
            System.out.println("[DispenseState] Dispensing product: " + product.getName() + " (₹" + product.getPrice() + ")");
            machine.deductAmount(product.getPrice());
            System.out.println("[DispenseState] Deducted ₹" + product.getPrice() + ". Remaining balance: ₹" + machine.getAmount());
        } else {
            System.out.println("[DispenseState] No product found in rack.");
        }

        // return remaining balance if any
        returnChange(machine);

        // reset to no money state
        machine.setCurrentState(new NoMoneyInsertedState());
        System.out.println("[DispenseState] Transitioning back to NoMoneyInsertedState.");
    }
}
