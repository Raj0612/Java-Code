package Educative.OnlineShopping.payments;

import Educative.OnlineShopping.enums.PaymentStatus;

public class Cash extends Payment {
    private String billingAddress;

    public Cash(double amount, String billingAddress) {
        super(amount);
        this.billingAddress = billingAddress;
    }

    public PaymentStatus makePayment() {
    // For cash on delivery, we assume the payment is pending and confirmed later.
        this.status = PaymentStatus.PENDING;
        System.out.println("Cash payment of $" + amount + " will be collected on delivery.");
        return status;
    }
}

