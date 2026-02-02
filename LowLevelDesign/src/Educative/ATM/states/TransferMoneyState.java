package Educative.ATM.states;

import Educative.ATM.bank.ATM;
import Educative.ATM.bank.ATMCard;
import Educative.ATM.bank.BankAccount;
import Educative.ATM.enums.TransactionType;

public class TransferMoneyState extends ATMState {

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
        System.out.println("Already in transfer money operation.");
    }

    @Override
    public void cashWithdrawal(ATM atm, ATMCard card, int withdrawAmount) {
        System.out.println("Cannot withdraw cash during money transfer.");
    }

    @Override
    public void displayBalance(ATM atm, ATMCard card) {
        System.out.println("Cannot display balance during money transfer.");
    }

    @Override
    public void transferMoney(ATM atm, ATMCard card, int accountNumber, int transferAmount) {
        BankAccount fromAccount = card.getBankAccount();
        BankAccount toAccount = atm.findAccountByNumber(accountNumber); // Assume this method exists
        if (toAccount == null) {
            System.out.println("Recipient account not found.");
        } else if (fromAccount.withdraw(transferAmount)) {
            toAccount.deposit(transferAmount);
            System.out.println("Transferred " + transferAmount + " to account " + accountNumber);
        } else {
            System.out.println("Insufficient funds for transfer.");
        }
        atm.setState(new SelectOperationState());
    }

    @Override
    public void returnCard(ATM atm) {
        System.out.println("Returning card. Thank you for using the ATM.");
    }

    @Override
    public void exit(ATM atm) {
        System.out.println("Ending transfer operation. Returning to select operation state.");
        atm.setState(atm.getSelectOperationState());
    }
}