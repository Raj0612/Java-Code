package Educative.ATM.main;

import Educative.ATM.bank.ATM;
import Educative.ATM.bank.ATMCard;
import Educative.ATM.bank.*;
import Educative.ATM.components.*;
import Educative.ATM.enums.*;

import java.time.LocalDate;
import java.util.Scanner;

public class ATMDemo2 {

    public static void main(String[] args) {
        // Initialize bank and accounts
        Bank bank = new Bank("MyBank", "MB001");

        CurrentAccount currentAccount = new CurrentAccount(1001, 2000, "John Doe");
        SavingAccount savingAccount = new SavingAccount(1002, 3000, "Jane Smith");

        ATMCard card1 = new ATMCard("1234-5678-9876-5432", "John Doe", LocalDate.of(2026, 12, 31), 1234);
        ATMCard card2 = new ATMCard("4321-8765-6789-2345", "Jane Smith", LocalDate.of(2028, 12, 31), 4321);

        currentAccount.setAtmCard(card1);
        savingAccount.setAtmCard(card2);

        card1.setBankAccount(currentAccount);
        card2.setBankAccount(savingAccount);

        bank.getAccounts().put(currentAccount.getAccountNumber(), currentAccount);
        bank.getAccounts().put(savingAccount.getAccountNumber(), savingAccount);

        // Initialize ATM components
        CardReader cardReader = new CardReader();
        CashDispenser cashDispenser = new CashDispenser(10, 10, 10); // 10 bills each
        Keypad keypad = new Keypad();
        Printer printer = new Printer();
        Screen screen = new Screen();

        // Instantiate ATM using default constructor
        ATM atm = ATM.getInstance();

        atm.setBank(bank);
        // Set components
        atm.setCardReader(cardReader);
        atm.setCashDispenser(cashDispenser); // 10 bills each
        atm.setKeypad(new Keypad());
        atm.setScreen(new Screen());
        atm.setPrinter(new Printer());

        // Initialize ATM cash
        atm.initializeATM(10000, 10, 10, 10);

        screen.display("Welcome to MyBank ATM!");

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the ATM System");

        // Insert card
        screen.display("Please insert your card.");
        atm.insertCard(card1);
        System.out.println("\nInserting card: " + card1.getCardNumber());

        // Enter PIN using keypad
        screen.display("Enter your PIN:");
        int enteredPin = keypad.getInput();
        atm.authenticatePin(card1, enteredPin);

        boolean sessionActive = true;
        while (sessionActive) {
            System.out.println("\n===== ATM Menu =====");
            System.out.println("1. Check Balance");
            System.out.println("2. Withdraw Cash");
            System.out.println("3. Deposit Cash");
            System.out.println("4. Transfer Money");
            System.out.println("5. Exit");
            System.out.print("Select an option (1-5): ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    atm.selectOperation(card1, TransactionType.CHECK_BALANCE);
                    atm.displayBalance(card1);
                    break;
                case 2:
                    atm.selectOperation(card1, TransactionType.CASH_WITHDRAWAL);
                    // Withdrawal amount input handled inside SelectOperationState
                    break;
                case 3:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    currentAccount.deposit(depositAmount);
                    atm.getScreen().display("Deposited $" + depositAmount + " successfully.");
                    break;
                case 4:
                    atm.selectOperation(card1, TransactionType.TRANSFER_MONEY);
                    System.out.print("Enter recipient account number: ");
                    int recipientAccount = scanner.nextInt();
                    System.out.print("Enter amount to transfer: $");
                    int transferAmount = scanner.nextInt();
                    atm.transferMoney(card1, recipientAccount, transferAmount);
                    break;
                case 5:
                    sessionActive = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }

            if (sessionActive) {
                System.out.print("\nWould you like to perform another transaction? (y/n): ");
                String answer = scanner.next();
                if (!answer.toLowerCase().startsWith("y")) {
                    sessionActive = false;
                }
            }
        }

        // Print receipt
        String receiptDetails = "Transaction Summary:\n" +
                "Account: " + currentAccount.getAccountNumber() + "\n" +
                "Balance: " + currentAccount.getAvailableBalance();
        atm.getPrinter().printReceipt(receiptDetails);

        // Return card and exit
        atm.returnCard();
        atm.exit();

        System.out.println("\nThank you for using ABC Bank ATM. Have a nice day!");

    }
}
