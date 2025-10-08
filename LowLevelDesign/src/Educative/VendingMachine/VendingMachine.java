package Educative.VendingMachine;

import Educative.VendingMachine.states.NoMoneyInsertedState;
import Educative.VendingMachine.states.State;
import Educative.VendingMachine.subjects.Inventory;
import Educative.VendingMachine.subjects.Rack;

import java.util.List;

public class VendingMachine {
    private State currentState;
    private double amount;
    private final Inventory inventory;

    private static VendingMachine vendingMachine = null;

    private VendingMachine() {
        this.currentState = new NoMoneyInsertedState();
        this.amount = 0.0;
        this.inventory = new Inventory();
    }

    public static VendingMachine getInstance() {
        if (vendingMachine == null) {
            vendingMachine = new VendingMachine();
        }
        return vendingMachine;
    }

    public void insertMoney(double amount) {
        currentState.insertMoney(this, amount);
    }

    public void pressButton(int rackNumber) {
        currentState.pressButton(this, rackNumber);
    }

    public void returnChange() {
        currentState.returnChange(this);
    }

    public void updateInventory(int rackNumber) {
        currentState.updateInventory(this, rackNumber);
    }

    public void dispenseProduct(int rackNumber) {
        currentState.dispenseProduct(this, rackNumber);
    }

    // --- Helper methods ---
    public void setCurrentState(State state) {
        this.currentState = state;
    }

    public State getCurrentState() {
        return currentState;
    }

    public void addAmount(double amount) {
        this.amount += amount;
    }

    public void deductAmount(double amt) {
        this.amount -= amt;
    }

    public void resetAmount() {
        this.amount = 0.0;
    }

    public double getAmount() {
        return amount;
    }

    public Inventory getInventory() {
        return inventory;
    }
}
