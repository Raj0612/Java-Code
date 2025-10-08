package Educative.ChessGame.accounts;

import Educative.ChessGame.enums.AccountStatus;

public class Account {
    private int id;
    private String password;
    private AccountStatus status;

    public boolean resetPassword() {
        // Implement password reset logic
        return true;
    }

    public int getId() {
        return id;
    }
    public AccountStatus getStatus() {
        return status;
    }
}
