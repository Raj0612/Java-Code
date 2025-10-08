package Educative.CarRentalSyatem.payment;

import Educative.CarRentalSyatem.designpatterns.PaymentStrategy;

public class CashPayment implements PaymentStrategy {
    @Override
    public boolean pay(double amount) {
        System.out.println("Processing cash payment of $" + amount);
        // Implement cash payment logic here
        return true;
    }
}
