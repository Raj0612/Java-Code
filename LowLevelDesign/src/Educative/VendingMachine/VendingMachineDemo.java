package Educative.VendingMachine;
import Educative.VendingMachine.enums.ProductType;
import Educative.VendingMachine.subjects.Product;
import Educative.VendingMachine.subjects.Rack;

public class VendingMachineDemo {
    public static void main(String[] args) {
        VendingMachine machine = VendingMachine.getInstance();

        // Setup inventory
        Rack rack1 = new Rack(1);
        rack1.addProduct(new Product("Coke", 101, 35, ProductType.BEVERAGE));
        rack1.addProduct(new Product("Coke", 102, 35, ProductType.BEVERAGE));

        Rack rack2 = new Rack(2);
        rack2.addProduct(new Product("Snickers", 201, 25, ProductType.CHOCOLATE));

        machine.getInventory().addRack(rack1);
        machine.getInventory().addRack(rack2);

        // Demo
        System.out.println("\n--- Vending Machine Demo ---");

        machine.insertMoney(20);
        machine.pressButton(1); // insufficient money

        machine.insertMoney(20);
        machine.pressButton(1); // should dispense Coke

        machine.insertMoney(50);
        machine.pressButton(2); // dispense Snickers + return change
    }
}
