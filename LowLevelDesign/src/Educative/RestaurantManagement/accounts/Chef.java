package Educative.RestaurantManagement.accounts;

import Educative.RestaurantManagement.enums.OrderStatus;
import Educative.RestaurantManagement.meals.Order;

import java.time.LocalDate;

public class Chef extends Employee {
    boolean assigned;

    public Chef(String name, String email, String phone, int employeeID, LocalDate dateJoined, Account account) {
        super(name, email, phone, employeeID, dateJoined, account);
    }
    public boolean prepareOrder(Order order) {
        if (order == null) return false;
        order.setStatus(OrderStatus.Preparing);
        // Simulate preparation
        order.setStatus(OrderStatus.Complete);
        // Notify waiter (could be an observer pattern in full implementation)
        System.out.println("Order " + order.getOrderID() + " is ready for the waiter.");
        return true;
    }

    public boolean isAssigned() {
        return assigned;
    }

    public void setAssigned(boolean assigned) {
        this.assigned = assigned;
    }
}
