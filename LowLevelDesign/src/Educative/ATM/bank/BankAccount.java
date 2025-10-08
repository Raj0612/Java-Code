package Educative.ATM.bank;

public abstract class BankAccount {
    public int accountNumber;

    public String accountHolderName;

    public double totalBalance;
    public double availableBalance;

    public ATMCard atmCard;


    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public double getTotalBalance() {
        return totalBalance;
    }

    public double getAvailableBalance() {
        return availableBalance;
    }

    public void setTotalBalance(double totalBalance) {
        this.totalBalance = totalBalance;
    }

    public void setAvailableBalance(double availableBalance) {
        this.availableBalance = availableBalance;
    }
    public ATMCard getAtmCard() {
        return atmCard;
    }
    public void setAtmCard(ATMCard atmCard) {
        this.atmCard = atmCard;
    }

    public abstract void deposit(double amount);
    public abstract boolean withdraw(double amount);
}
