package Educative.ATM.states;

import Educative.ATM.bank.ATM;
import Educative.ATM.bank.ATMCard;
import Educative.ATM.enums.TransactionType;

import java.util.Scanner;

public class SelectOperationState extends ATMState {
    @Override
    public void insertCard(ATM atm, ATMCard card) {
        System.out.println("Card already inserted. Please select an operation.");
    }

    @Override
    public void authenticatePin(ATM atm, ATMCard card, int pin) {
        System.out.println("PIN already authenticated. Please select an operation.");
    }

    @Override
    public void selectOperation(ATM atm, ATMCard card, TransactionType tType) {
        switch (tType) {
            case CASH_WITHDRAWAL:
                atm.setState(atm.getCashWithdrawalState());
                Scanner scanner = new Scanner(System.in);
                while (true) {
                    System.out.println("Enter Amount to withdraw:");
                    int withdrawAmount = scanner.nextInt();
                    if(card.getBankAccount().getAvailableBalance() < withdrawAmount){
                        atm.getScreen().display("Insufficient funds. Please try again.");
                        continue;
                    }
                    atm.cashWithdrawal(card, withdrawAmount);
                    break;
                }
                break;
            case CHECK_BALANCE:
                atm.setState(atm.getCheckBalanceState());
                atm.checkBankBalance(card);
                double balance = card.getBankAccount().getAvailableBalance();
                atm.getScreen().display("Available balance: $" + balance);
                atm.getCheckBalanceState().displayBalance(atm, card);

                break;
            case TRANSFER_MONEY:
                atm.setState(atm.getTransferMoneyState());
                break;
            default:
                System.out.println("Invalid operation selected.");
        }
    }

    @Override
    public void cashWithdrawal(ATM atm, ATMCard card, int withdrawAmount) {
        System.out.println("Please select cash withdrawal operation first.");
    }

    @Override
    public void displayBalance(ATM atm, ATMCard card) {
        System.out.println("Please select check balance operation first.");
    }

    @Override
    public void transferMoney(ATM atm, ATMCard card, int accountNumber, int transferAmount) {
        System.out.println("Please select transfer money operation first.");
    }

    @Override
    public void returnCard(ATM atm) {
        System.out.println("Returning card. Thank you for using the ATM.");
    }

    @Override
    public void exit(ATM atm) {
        System.out.println("Session ended. Returning to idle state.");
        atm.setState(atm.getIdleState());
    }
}