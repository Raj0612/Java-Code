package Educative.AirlineManagement.payments;

import Educative.AirlineManagement.enums.PaymentStatus;

public class Cash extends Payment {
    public Cash(int paymentId, double amount) { super(paymentId, amount); }
    @Override
    public boolean makePayment() {
        setStatus(PaymentStatus.COMPLETED);
        return true;
    }
}
