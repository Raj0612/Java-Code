package Educative.ATM.states;

import Educative.ATM.bank.ATM;
import Educative.ATM.bank.ATMCard;
import Educative.ATM.enums.TransactionType;

public class IdleState extends ATMState {

    @Override
    public void insertCard(ATM atm, ATMCard card) {
        atm.getCardReader().readCard(card);
        atm.setState(atm.getHasCardState() );
    }
    @Override
    public void authenticatePin(ATM atm, ATMCard card, int pin) {
        System.out.println("No card inserted.");
    }
    @Override
    public void selectOperation(ATM atm, ATMCard card, TransactionType tType) {
        System.out.println("No card inserted.");
    }
    @Override
    public void cashWithdrawal(ATM atm, ATMCard card, int withdrawAmount) {
        System.out.println("No card inserted.");
    }
    @Override
    public void displayBalance(ATM atm, ATMCard card) {
        System.out.println("No card inserted.");
    }
    @Override
    public void transferMoney(ATM atm, ATMCard card, int accountNumber, int transferAmount) {
        System.out.println("No card inserted.");
    }
    @Override
    public void returnCard(ATM atm) {
        System.out.println("No card to return.");
    }
    @Override
    public void exit(ATM atm) {
        System.out.println("ATM already idle.");
    }
}
