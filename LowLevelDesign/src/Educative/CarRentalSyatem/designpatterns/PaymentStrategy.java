package Educative.CarRentalSyatem.designpatterns;

//Implemented in CreditCardPayment and CashPayment
public interface PaymentStrategy {
    boolean pay(double amount);
}
