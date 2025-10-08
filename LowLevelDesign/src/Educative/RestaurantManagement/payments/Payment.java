package Educative.RestaurantManagement.payments;

import Educative.RestaurantManagement.enums.PaymentStatus;
import Educative.RestaurantManagement.payments.strategy.DiscountStrategy;
import Educative.RestaurantManagement.payments.strategy.NoDiscount;

import java.time.LocalDate;
public abstract class Payment {

    private int paymentID;
    private LocalDate creationDate;
    private double amount;
    private PaymentStatus status;
    protected DiscountStrategy discountStrategy;

    public Payment(int paymentID, double amount, PaymentStatus status) {
        this.paymentID = paymentID;
        this.creationDate = LocalDate.now();
        this.amount = amount;
        this.status = status;
        this.discountStrategy = new NoDiscount();
    }

    public void setDiscountStrategy(DiscountStrategy strategy) {
        this.discountStrategy = strategy;
    }

    public double applyDiscount() {
        this.amount = discountStrategy.applyDiscount(this.amount, this.creationDate);
        return this.amount;
    }

    public abstract void initiateTransaction();

    public int getPaymentID() {
        return paymentID;
    }

    public void setPaymentID(int paymentID) {
        this.paymentID = paymentID;
    }
    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public PaymentStatus getStatus() {
        return status;
    }

    public void setStatus(PaymentStatus status) {
        this.status = status;
    }

    public String toString() {
        return "Payment{" +
                "paymentID=" + paymentID +
                ", creationDate=" + creationDate +
                ", amount=" + amount +
                ", status=" + status +
                '}';
    }
}
