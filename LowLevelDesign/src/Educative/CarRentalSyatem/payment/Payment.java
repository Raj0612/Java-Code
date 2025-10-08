package Educative.CarRentalSyatem.payment;


import Educative.CarRentalSyatem.designpatterns.PaymentStrategy;
import Educative.CarRentalSyatem.enums.PaymentStatus;

import java.time.LocalDateTime;

public class Payment {
    private double amount;
    private PaymentStatus status;
    private LocalDateTime timestamp;
    private PaymentStrategy paymentStrategy;

    public Payment(double amount, PaymentStrategy paymentStrategy) {
        this.amount = amount;
        this.paymentStrategy = paymentStrategy;
        this.timestamp = LocalDateTime.now();
        this.status = PaymentStatus.UNPAID;
    }

    public boolean makePayment() {
        boolean success = paymentStrategy.pay(amount);
        if (success) {
            status = PaymentStatus.COMPLETED;
        } else {
            status = PaymentStatus.CANCELED;
        }
        return success;
    }

    public double getAmount() {
        return amount;
    }

    public PaymentStatus getStatus() {
        return status;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public PaymentStrategy getPaymentStrategy() {
        return paymentStrategy;
    }

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setStatus(PaymentStatus status) {
        this.status = status;
    }
}