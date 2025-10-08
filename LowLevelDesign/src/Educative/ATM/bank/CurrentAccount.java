package Educative.ATM.bank;

public class CurrentAccount extends BankAccount {
    private static final double OVERDRAFT_LIMIT = 1000;

    public CurrentAccount(int accountNumber, double initialBalance, String accountHolderName) {
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
        if (getAvailableBalance() + OVERDRAFT_LIMIT >= amount) {
            setTotalBalance(getTotalBalance() - amount);
            setAvailableBalance(getAvailableBalance() - amount);
            return true;
        } else {
            System.out.println("Withdrawal denied: Overdraft limit exceeded.");
            return false;
        }
    }
}
