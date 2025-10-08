package Educative.RestaurantManagement.payments.strategy;

import java.time.LocalDate;

public class NoDiscount implements DiscountStrategy {
    public double applyDiscount(double amount, LocalDate date) {
        return amount;
    }
}
