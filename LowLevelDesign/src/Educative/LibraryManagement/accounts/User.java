package Educative.LibraryManagement.accounts;

import Educative.LibraryManagement.enums.AccountStatus;

public abstract class User {
    protected String id, password;
    protected AccountStatus status;
    protected Person person;
    protected LibraryCard card;

    public User(String id, String password, AccountStatus status, Person person, LibraryCard card) {
        this.id = id;
        this.password = password;
        this.status = status;
        this.person = person;
        this.card = card;
    }

    public String getId() {
        return id;
    }

    public LibraryCard getCard() {
        return card;
    }

    public Person getPerson() {
        return person;
    }

    public AccountStatus getStatus() {
        return status;
    }

    public void setStatus(AccountStatus status) {
        this.status = status;
    }

    public abstract boolean resetPassword(String newPassword);
}
