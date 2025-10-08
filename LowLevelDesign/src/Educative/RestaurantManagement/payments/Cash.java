package Educative.RestaurantManagement.payments;

import Educative.RestaurantManagement.enums.PaymentStatus;

public class Cash extends Payment {
    private double cashTendered;

    public Cash(int paymentID, double amount, PaymentStatus status, double cashTendered) {
        super(paymentID, amount, status);
        this.cashTendered = cashTendered;
    }

    public void initiateTransaction() {
        // Cash payment logic
        setStatus(PaymentStatus.Completed);
    }

    public double getCashTendered() {
        return cashTendered;
    }

    public void setCashTendered(double cashTendered) {
        this.cashTendered = cashTendered;
    }

    public String toString() {
        return super.toString()  + "\nCash Tendered: " + cashTendered;
    }
}
