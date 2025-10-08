package Educative.StockBrokerage.orders;

import java.time.LocalDate;

public class OrderPart {
    private double price;
    private double quantity;
    private LocalDate executedAt;

    public OrderPart(double price, double quantity) {
        this.price = price;
        this.quantity = quantity;
        this.executedAt = LocalDate.now();
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public LocalDate getExecutedAt() {
        return executedAt;
    }

    public void setExecutedAt(LocalDate executedAt) {
        this.executedAt = executedAt;
    }
}
