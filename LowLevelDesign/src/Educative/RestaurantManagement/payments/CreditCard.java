package Educative.RestaurantManagement.payments;

import Educative.RestaurantManagement.enums.PaymentStatus;

public class CreditCard extends Payment {

    private String nameOnCard;
    private int zipcode;

    public CreditCard(int paymentID, double amount, PaymentStatus status, String nameOnCard, int zipcode) {
        super(paymentID, amount, status);
        this.nameOnCard = nameOnCard;
        this.zipcode = zipcode;
    }

    public void initiateTransaction() {
        // Credit card payment logic
        setStatus(PaymentStatus.Completed);
    }

    public String getNameOnCard() {
        return nameOnCard;
    }

    public void setNameOnCard(String nameOnCard) {
        this.nameOnCard = nameOnCard;
    }

    public int getZipcode() {
        return zipcode;
    }

    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
    }

    public String toString() {
        return super.toString() + "\nName on Card: " + nameOnCard + "\nZipcode: " + zipcode;
    }
}
