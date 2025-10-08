package Educative.MovieBookingSystem.payments;

import Educative.MovieBookingSystem.enums.PaymentStatus;

public class CashPayment extends Payment {
    public CashPayment(double amount) {
        super(amount);
    }

    @Override
    public boolean makePayment() {
        // Cash payment always succeeds for simplicity
        setStatus(PaymentStatus.CONFIRMED);
        System.out.println("Cash Payment of $" + getAmount() + " confirmed.");
        return true;
    }
}

