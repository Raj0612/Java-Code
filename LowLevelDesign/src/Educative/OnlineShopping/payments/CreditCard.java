package Educative.OnlineShopping.payments;

import Educative.OnlineShopping.enums.PaymentStatus;

public class CreditCard  extends Payment {
    private String nameOnCard;
    private String cardNumber;
    private String billingAddress;
    private int code;

    public CreditCard(double amount, String nameOnCard, String cardNumber, String billingAddress, int code) {
        super(amount);
        this.nameOnCard = nameOnCard;
        this.cardNumber = cardNumber;
        this.billingAddress = billingAddress;
        this.code = code;
    }

    public PaymentStatus makePayment() {
        // Dummy implementation – assume credit card payment is confirmed.
        this.status = PaymentStatus.CONFIRMED;
        System.out.println("Credit card payment of $" + amount + " made.");
        return status;
    }
}
