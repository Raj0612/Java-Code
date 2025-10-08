package Educative.RestaurantManagement.payments.strategy;

import java.time.LocalDate;

public interface DiscountStrategy {
    double applyDiscount(double amount, LocalDate date);
}
