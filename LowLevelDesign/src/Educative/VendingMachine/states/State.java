package Educative.VendingMachine.states;

import Educative.VendingMachine.VendingMachine;

public interface State {
    void insertMoney(VendingMachine machine, double amount);
    void pressButton(VendingMachine machine, int rackNumber);
    void returnChange(VendingMachine machine);
    void updateInventory(VendingMachine machine, int rackNumber);
    void dispenseProduct(VendingMachine machine, int rackNumber);
}
