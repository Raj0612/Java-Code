package Educative.OnlineShopping.payments;

import Educative.OnlineShopping.enums.PaymentStatus;

import java.time.LocalDate;

public abstract class Payment {
    protected double amount;
    protected LocalDate timestamp;
    protected PaymentStatus status;

    public Payment(double amount) {
        this.amount = amount;
        this.timestamp = LocalDate.now();
        this.status = PaymentStatus.PENDING;
    }

    public abstract PaymentStatus makePayment();
}
