package Educative.ParkingLot.accounts;

import Educative.ParkingLot.enums.AccountStatus;

public abstract class Account {
    private String userName;
    private String password;
    private Person person;
    private AccountStatus status;

    public Account(String userName, String password, Person person, AccountStatus status) {
        this.userName = userName;
        this.password = password;
        this.person = person;
        this.status = status;
    }

    public abstract boolean resetPassword();

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public AccountStatus getStatus() {
        return status;
    }

    public void setStatus(AccountStatus status) {
        this.status = status;
    }
}
