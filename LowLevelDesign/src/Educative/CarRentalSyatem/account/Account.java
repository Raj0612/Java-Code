package Educative.CarRentalSyatem.account;

import Educative.CarRentalSyatem.enums.AccountStatus;

public abstract class Account extends Person {
    private String accountId;
    private String password;
    private AccountStatus status;

    public Account() {
    }

    public Account(String accountId, String password, AccountStatus status,
                   String name, Address address, String email, String phoneNumber) {
        super(name, address, email, phoneNumber);
        this.accountId = accountId;
        this.password = password;
        this.status = status;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public AccountStatus getStatus() {
        return status;
    }

    public void setStatus(AccountStatus status) {
        this.status = status;
    }

    public abstract boolean resetPassword();
}