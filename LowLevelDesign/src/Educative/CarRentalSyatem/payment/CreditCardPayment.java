package Educative.CarRentalSyatem.payment;

import Educative.CarRentalSyatem.designpatterns.PaymentStrategy;

public class CreditCardPayment implements PaymentStrategy {
    private String cardNumber;
    private String cardHolderName;
    private String expiryDate;
    private String cvv;

    public CreditCardPayment(String cardNumber, String cardHolderName, String expiryDate, String cvv) {
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
        this.expiryDate = expiryDate;
        this.cvv = cvv;
    }

    @Override
    public boolean pay(double amount) {
        System.out.println("Processing credit card payment of $" + amount);
        // Implement credit card payment logic here
        return true;
    }
}
