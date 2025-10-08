package Educative.AirlineManagement.accounts;

import Educative.AirlineManagement.enums.AccountStatus;

public class Account {
    private AccountStatus status;
    private int accountId;
    private String username;
    private String password;

    public Account(int accountId, String username, String password, AccountStatus status) {
        this.accountId = accountId;
        this.username = username;
        this.password = password;
        this.status = status;
    }

    public boolean resetPassword(String newPassword) {
        if (newPassword != null && !newPassword.isEmpty()) {
            this.password = newPassword;
            return true;
        }
        return false;
    }

    public AccountStatus getStatus() {
        return status;
    }

    public void setStatus(AccountStatus status) {
        this.status = status;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
