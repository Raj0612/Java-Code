package Educative.HotelManagement.invoices;

import Educative.ParkingLot.enums.PaymentStatus;

import java.time.LocalDateTime;

public abstract class BillTransaction {

    protected LocalDateTime creationDate;
    protected double amount;
    protected PaymentStatus status;
    public BillTransaction(double amount) {
        this.creationDate = LocalDateTime.now();
        this.amount = amount;
        this.status = PaymentStatus.UNPAID;
    }
    public abstract void initiateTransaction();

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
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
}
