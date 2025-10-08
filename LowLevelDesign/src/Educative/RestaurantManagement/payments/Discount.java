package Educative.RestaurantManagement.payments;

import java.time.LocalDate;

public class Discount {

    private String description;
    private double percentage; // 0.10 for 10%
    private LocalDate startDate;
    private LocalDate endDate;

    public Discount(String description, double percentage, LocalDate startDate, LocalDate endDate) {
        this.description = description;
        this.percentage = percentage;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public boolean isApplicable(LocalDate date) {
        return !date.isBefore(startDate) && !date.isAfter(endDate);
    }

    public double getDiscountAmount(double amount) {
        return amount * percentage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String toString() {
        return "Discount{" +
                "description='" + description + '\'' +
                ", percentage=" + percentage +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
