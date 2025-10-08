package Educative.RestaurantManagement.accounts;

import Educative.RestaurantManagement.enums.AccountStatus;

public class Account {
    private String accountId;
    private String password;
    private Address address;
    private AccountStatus status;

    public boolean resetPassword(String newPassword) {
        if (newPassword == null || newPassword.isEmpty()) return false;
        this.password = newPassword;
        return true;
    }
}
