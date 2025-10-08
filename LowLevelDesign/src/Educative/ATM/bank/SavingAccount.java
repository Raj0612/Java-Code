package Educative.ATM.bank;

public class SavingAccount extends BankAccount {
    private static final double MIN_BALANCE = 500;
    public SavingAccount(int accountNumber, double initialBalance, String accountHolderName) {
        this.accountNumber = accountNumber;
        this.totalBalance = initialBalance;
        this.availableBalance = initialBalance;
        this.accountHolderName = accountHolderName;
    }

    @Override
    public void deposit(double amount) {
        setTotalBalance(getTotalBalance() + amount);
        setAvailableBalance(getAvailableBalance() + amount);
    }

    @Override
    public boolean withdraw(double amount) {
        if (getAvailableBalance() - amount >= MIN_BALANCE) {
            setTotalBalance(getTotalBalance() - amount);
            setAvailableBalance(getAvailableBalance() - amount);
            return true;
        } else {
            System.out.println("Withdrawal denied: Minimum balance requirement not met.");
            return false;
        }
    }
}
