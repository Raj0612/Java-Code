package Educative.MovieBookingSystem.payments;

import Educative.MovieBookingSystem.enums.PaymentStatus;

import java.time.LocalDateTime;

public abstract class Payment {
    private final double amount;
    private final LocalDateTime timestamp;
    private PaymentStatus status;

    public Payment(double amount) {
        this.amount = amount;
        this.timestamp = LocalDateTime.now();
        this.status = PaymentStatus.PENDING;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public PaymentStatus getStatus() {
        return status;
    }

    protected void setStatus(PaymentStatus status) {
        this.status = status;
    }

    public abstract boolean makePayment();
}
