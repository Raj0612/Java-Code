package Educative.HotelManagement.invoices;

import Educative.ParkingLot.enums.PaymentStatus;

public class CreditCardTransaction extends BillTransaction {
    private String nameOnCard;
    private int zipcode;
    public CreditCardTransaction(double amt, String name, int zip) {
        super(amt);
        this.nameOnCard = name;
        this.zipcode = zip;
    }
    public void initiateTransaction() {
        this.status = PaymentStatus.COMPLETED;
        System.out.println("Credit card payment completed.");
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
}
