package Educative.ATM.states;

import Educative.ATM.bank.ATM;
import Educative.ATM.bank.ATMCard;
import Educative.ATM.enums.TransactionType;

public class HasCardState extends ATMState {

    @Override
    public void insertCard(ATM atm, ATMCard card) {
        System.out.println("Card already inserted.");
    }
    @Override
    public void authenticatePin(ATM atm, ATMCard card, int pin) {
        if (card.validatePin(pin)) {
            System.out.println("PIN correct. Select operation.");
            atm.setState(atm.getSelectOperationState());
        } else {
            System.out.println("Incorrect PIN. Please try again.");
        }
    }
    @Override
    public void selectOperation(ATM atm, ATMCard card, TransactionType tType) {
        System.out.println("Authenticate PIN first.");
    }
    @Override
    public void cashWithdrawal(ATM atm, ATMCard card, int withdrawAmount) {
        System.out.println("Authenticate PIN first.");
    }
    @Override
    public void displayBalance(ATM atm, ATMCard card) {
        System.out.println("Authenticate PIN first.");
    }
    @Override
    public void transferMoney(ATM atm, ATMCard card, int accountNumber, int transferAmount) {
        System.out.println("Authenticate PIN first.");
    }
    @Override
    public void returnCard(ATM atm) {
        System.out.println("Returning card. Going to idle state.");;
        // Assuming ATM context is available to set state to Idle
        atm.setState(atm.getIdleState());
    }
    @Override
    public void exit(ATM atm) {
        System.out.println("Exiting and returning card.");
        atm.setState( atm.getIdleState());
    }
}
