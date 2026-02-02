package Educative.ATM.states;

import Educative.ATM.bank.ATM;
import Educative.ATM.bank.ATMCard;
import Educative.ATM.bank.BankAccount;
import Educative.ATM.enums.TransactionType;

public class CashWithdrawalState extends ATMState {

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
        System.out.println("Already in cash withdrawal operation.");
    }

    @Override
    public void cashWithdrawal(ATM atm, ATMCard card, int withdrawAmount) {
        // Assume ATMCard has a reference to BankAccount

        atm.dispenseCash(withdrawAmount);

        BankAccount account = card.getBankAccount();
        if (account.withdraw(withdrawAmount)) {
            atm.getScreen().display("Please collect your cash: " + withdrawAmount);
        } else {
            atm.getScreen().display("Insufficient funds.");
        }
        atm.setState(atm.getSelectOperationState());
    }

    @Override
    public void displayBalance(ATM atm, ATMCard card) {
        System.out.println("Cannot display balance during cash withdrawal operation.");
    }

    @Override
    public void transferMoney(ATM atm, ATMCard card, int accountNumber, int transferAmount) {
        System.out.println("Cannot transfer money during cash withdrawal operation.");
    }

    @Override
    public void returnCard(ATM atm) {
        System.out.println("Returning card. Thank you for using the ATM.");
    }

    @Override
    public void exit(ATM atm) {
        System.out.println("Ending withdrawal operation. Returning to select operation state.");
        atm.setState(atm.getSelectOperationState());}
}
