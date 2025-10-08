package Educative.ATM.main;

import Educative.ATM.bank.ATM;
import Educative.ATM.bank.ATMCard;
import Educative.ATM.bank.BankAccount;
import Educative.ATM.bank.SavingAccount;
import Educative.ATM.enums.TransactionType;

import java.time.LocalDate;
import java.util.Scanner;

public class ATMDemo {
    public static void main(String[] args) {
        ATM atm = ATM.getInstance();
        atm.initializeATM(10000, 50, 50, 200);
        System.out.println("Welcome to the ATM System");
        System.out.println("ATM initialized with $10,000");

        BankAccount account1 = new SavingAccount(123, 100, "John Doe");
        BankAccount account2 = new SavingAccount(456, 5000, "Jane Smith");
        BankAccount account3 = new SavingAccount(789, 2000, "Bob Johnson");

        ATMCard atmCard = new ATMCard("1234", "John Doe",  LocalDate.of(2026, 12, 31), 1234);
        ATMCard atmCard1 = new ATMCard("1235", "Jane Smith",  LocalDate.of(2028, 12, 31), 1234);

        account1.setAtmCard(atmCard);
        account2.setAtmCard(atmCard1);
        atmCard.setBankAccount(account1);
        atmCard1.setBankAccount(account2);

        System.out.println("\nCard inserted: " + atmCard.getCardNumber());
        atm.insertCard(atmCard);

        // PIN authentication
        System.out.println("\nEnter PIN: 5678");
        atm.authenticatePin(atmCard, 1234);

        // Display menu and process transactions
        boolean sessionActive = true;
        Scanner scanner = new Scanner(System.in);

        while (sessionActive) {
            System.out.println("\n===== ATM Menu =====");
            System.out.println("1. Check Balance");
            System.out.println("2. Withdraw Cash");
            System.out.println("3. Deposit Cash");
            System.out.println("4. Transfer Money");
            System.out.println("5. Exit");
            System.out.print("Select an option (1-5): ");

            int choice = 1; // Default to balance check for demo
            try {
                choice = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // Clear input buffer
                continue;
            }

            switch (choice) {
                case 1:
                    // Check balance
                    atm.selectOperation(atmCard, TransactionType.CHECK_BALANCE);
                    atm.displayBalance(atmCard);
                    break;

                case 2:
                    // Withdraw cash
                    atm.selectOperation(atmCard, TransactionType.CASH_WITHDRAWAL);
                    break;

                case 3:
                    // Deposit cash (assuming this functionality exists)
                    System.out.println("Deposit functionality not implemented in this demo");
                    break;

                case 4:
                    // Transfer money
                    atm.selectOperation(atmCard, TransactionType.TRANSFER_MONEY);
                    System.out.print("Enter recipient account number: ");
                    int recipientAccount = scanner.nextInt();
                    System.out.print("Enter amount to transfer: $");
                    int transferAmount = scanner.nextInt();
                    atm.transferMoney(atmCard, recipientAccount, transferAmount);
                    break;

                case 5:
                    // Exit
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
        atm.returnCard();
        atm.exit();
        System.out.println("\nThank you for using ABC Bank ATM. Have a nice day!");
    }
}
