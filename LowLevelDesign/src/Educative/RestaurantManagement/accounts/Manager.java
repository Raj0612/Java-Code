package Educative.RestaurantManagement.accounts;

import Educative.RestaurantManagement.restaurants.Restaurant;

import java.time.LocalDate;

public class Manager extends Employee {

    public Manager(String name, String email, String phone, int employeeID, LocalDate dateJoined, Account account) {
        super(name, email, phone, employeeID, dateJoined, account);
    }
    public boolean addEmployee(Employee employee) {
        return true;
    }
}
