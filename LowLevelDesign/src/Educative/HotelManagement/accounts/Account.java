package Educative.HotelManagement.accounts;

import Educative.HotelManagement.enums.AccountStatus;

public class Account {
    private String id, password;
    private AccountStatus status;

    public Account(String id, String password, AccountStatus status) {
        this.id = id;
        this.password = password;
        this.status = status;
    }
    public boolean resetPassword() { /* logic */ return true; }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
}
