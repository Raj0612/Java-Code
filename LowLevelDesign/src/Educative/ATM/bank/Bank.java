package Educative.ATM.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bank {
    private String name;
    private String bankCode;

    private List<ATM> atms = new ArrayList<>();

    private Map<Integer, BankAccount> accounts;

    public Bank(String name, String bankCode) {
        this.name = name;
        this.bankCode = bankCode;
        this.accounts = new HashMap<>();
    }
    public String getBankCode() {
        return bankCode;
    }


    public boolean addATM(ATM atm) {
        if (atm != null) {
            atms.add(atm);
            return true;
        }
        return false;
    }
    public String getName() {
        return name;
    }

    public Map<Integer, BankAccount> getAccounts() {
        return accounts;
    }

    public void setAccounts(Map<Integer, BankAccount> accounts) {
        this.accounts = accounts;
    }

    public BankAccount findAccountByNumber(int accountNumber) {
        if (accounts != null) {
            return accounts.get(accountNumber);
        }
        return null;
    }
}
