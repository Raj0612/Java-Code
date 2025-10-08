package Educative.ATM.states;

import Educative.ATM.bank.ATM;
import Educative.ATM.bank.ATMCard;
import Educative.ATM.bank.BankAccount;
import Educative.ATM.enums.TransactionType;

public class CheckBalanceState extends ATMState {

    @Override
    public void insertCard(ATM atm, ATMCard card) {
        System.out.println("A card is already inserted.");
    }

    @Override
    public void authenticatePin(ATM atm, ATMCard card, int pin) {
        System.out.println("PIN already authenticated.");
    }

    @Override
    public void selectOperation(ATM atm, ATMCard card, TransactionType tType) {
        System.out.println("Already in check balance operation.");
    }

    @Override
    public void cashWithdrawal(ATM atm, ATMCard card, int withdrawAmount) {
        System.out.println("Cannot withdraw cash during balance check.");
    }

    @Override
    public void displayBalance(ATM atm, ATMCard card) {
        BankAccount account = card.getBankAccount();
        atm.getScreen().display("Available Balance: " + account.getAvailableBalance());
        atm.setState(atm.getSelectOperationState());
    }

    @Override
    public void transferMoney(ATM atm, ATMCard card, int accountNumber, int transferAmount) {
        System.out.println("Cannot transfer money during balance check.");
    }

    @Override
    public void returnCard() {
        System.out.println("Returning card. Thank you for using the ATM.");
    }

    @Override
    public void exit(ATM atm) {
        System.out.println("Ending check balance operation. Returning to select operation state.");
        atm.setState(atm.getSelectOperationState());
    }
}
