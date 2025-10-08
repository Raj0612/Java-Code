package Educative.RestaurantManagement.payments;

import Educative.RestaurantManagement.enums.PaymentStatus;

public class Check extends Payment {
    private String bankName;
    private String checkNumber;

    public Check(int paymentID, double amount, PaymentStatus status,String bankName, String checkNumber) {
        super(paymentID, amount, status);
        this.bankName = bankName;
        this.checkNumber = checkNumber;
    }

    public void initiateTransaction() {
        // Check payment logic
        setStatus(PaymentStatus.Completed);
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getCheckNumber() {
        return checkNumber;
    }

    public void setCheckNumber(String checkNumber) {
        this.checkNumber = checkNumber;
    }

    public String toString() {
        return super.toString() + "\nBank Name: " + bankName + "\nCheck Number: " + checkNumber;
    }
}
