package Educative.RestaurantManagement.accounts;

import java.time.LocalDate;

public abstract class Employee extends Person {
    private int employeeID;
    private LocalDate dateJoined;
    private Account account;

    public Employee(String name, String email, String phone, int employeeID, LocalDate dateJoined, Account account) {
        super(name, email, phone);
        this.employeeID = employeeID;
        this.dateJoined = dateJoined;
        this.account = account;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public LocalDate getDateJoined() {
        return dateJoined;
    }

    public void setDateJoined(LocalDate dateJoined) {
        this.dateJoined = dateJoined;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}

