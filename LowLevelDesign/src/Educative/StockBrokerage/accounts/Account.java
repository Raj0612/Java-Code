package Educative.StockBrokerage.accounts;

import Educative.StockBrokerage.enums.AccountStatus;

public abstract class Account {
    protected String id;
    protected String password;
    protected String name;
    protected AccountStatus status;
    protected Address address;
    protected String email;
    protected String phone;

    public Account(String id, String password, String name, AccountStatus status, Address address, String email, String phone) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.status = status;
        this.address = address;
        this.email = email;
        this.phone = phone;
    }

    public abstract boolean resetPassword();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AccountStatus getStatus() {
        return status;
    }

    public void setStatus(AccountStatus status) {
        this.status = status;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
