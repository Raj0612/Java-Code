package LowLevelDesign.GitLab.Shrayansh8.DesignATM;

public class UserBankAccount {

    int balance;
    public void withdrawalBalance(int amount) {
        balance = balance - amount;
    }
}
