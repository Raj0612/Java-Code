package Educative.RestaurantManagement.payments.strategy;

import java.time.LocalDate;
import java.time.Month;

public class NewYearDiscount implements DiscountStrategy {
    @Override
    public double applyDiscount(double amount, LocalDate date) {
        // 10% off on January 1st
        if (date.getMonth() == Month.JANUARY && date.getDayOfMonth() == 1) {
            return amount * 0.9;
        }
        return amount;
    }
}
