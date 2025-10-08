package Educative.RestaurantManagement.commad;

import Educative.RestaurantManagement.payments.Payment;

public class ProcessPaymentCommand implements Command {
    private Payment payment;

    public ProcessPaymentCommand(Payment payment) {
        this.payment = payment;
    }

    @Override
    public void execute() {
        payment.initiateTransaction();
    }
}
