package Educative.ParkingLot.payments;

import Educative.ParkingLot.enums.PaymentStatus;

import java.time.LocalDateTime;

public class Cash extends Payment {
    public Cash(double amount) {
        super(amount);
    }

    @Override
    public boolean initiateTransaction() {
        // Simulate cash payment success
        this.status = PaymentStatus.COMPLETED;
        this.timestamp = LocalDateTime.now();
        System.out.println("Cash payment of $" + amount + " completed.");
        return true;
    }
}