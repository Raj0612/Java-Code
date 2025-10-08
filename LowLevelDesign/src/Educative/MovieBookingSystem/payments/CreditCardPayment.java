package Educative.MovieBookingSystem.payments;

import Educative.MovieBookingSystem.enums.PaymentStatus;

public class CreditCardPayment extends Payment {
    private final String nameOnCard;
    private final String cardNumber;
    private final String billingAddress;
    private final int cvv;

    public CreditCardPayment(double amount, String nameOnCard, String cardNumber, String billingAddress, int cvv) {
        super(amount);
        this.nameOnCard = nameOnCard;
        this.cardNumber = cardNumber;
        this.billingAddress = billingAddress;
        this.cvv = cvv;
    }

    @Override
    public boolean makePayment() {
        // Simplified credit card validation
        if (cardNumber.length() == 16 && cvv >= 100 && cvv <= 999) {
            setStatus(PaymentStatus.CONFIRMED);
            System.out.println("Credit Card Payment of $" + getAmount() + " confirmed.");
            return true;
        } else {
            setStatus(PaymentStatus.DECLINED);
            System.out.println("Credit Card Payment declined.");
            return false;
        }
    }
}
