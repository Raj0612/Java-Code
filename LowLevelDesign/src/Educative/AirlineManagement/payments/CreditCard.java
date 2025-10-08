package Educative.AirlineManagement.payments;

import Educative.AirlineManagement.enums.PaymentStatus;

public class CreditCard extends Payment {
    private String nameOnCard;
    private String cardNumber;

    public CreditCard(int paymentId, double amount, String nameOnCard, String cardNumber) {
        super(paymentId, amount);
        this.nameOnCard = nameOnCard;
        this.cardNumber = cardNumber;
    }

    @Override
    public boolean makePayment() {
        // Placeholder for credit card payment logic
        setStatus(PaymentStatus.COMPLETED);
        return true;
    }

    // Getters and setters
    public String getNameOnCard() {
        return nameOnCard;
    }

    public void setNameOnCard(String nameOnCard) {
        this.nameOnCard = nameOnCard;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }
}
