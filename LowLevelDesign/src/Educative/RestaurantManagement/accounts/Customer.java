package Educative.RestaurantManagement.accounts;

import java.time.LocalDate;

public class Customer extends Person {
    private LocalDate lastVisitedDate;

    public Customer(String name, String email, String phone, LocalDate lastVisitedDate) {
        super(name, email, phone);
        this.lastVisitedDate = lastVisitedDate;
    }

    public LocalDate getLastVisitedDate() {
        return lastVisitedDate;
    }

    public void setLastVisitedDate(LocalDate lastVisitedDate) {
        this.lastVisitedDate = lastVisitedDate;
    }

}

