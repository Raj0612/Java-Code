package Educative.ATM.bank;

import Educative.ATM.bank.BankAccount;

import java.time.LocalDate;

public class ATMCard {
    private String cardNumber;
    private String customerName;
    private LocalDate cardExpiryDate;
    private int pin;

    private BankAccount bankAccount;

    public ATMCard(String cardNumber, String customerName, LocalDate cardExpiryDate, int pin) {
        this.cardNumber = cardNumber;
        this.customerName = customerName;
        this.cardExpiryDate = cardExpiryDate;
        this.pin = pin;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public LocalDate getCardExpiryDate() {
        return cardExpiryDate;
    }

    public void setCardExpiryDate(LocalDate cardExpiryDate) {
        this.cardExpiryDate = cardExpiryDate;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }
    public boolean validatePin(int enteredPin) {
        return enteredPin == pin;
    }
}
