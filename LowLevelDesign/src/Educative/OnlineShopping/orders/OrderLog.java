package Educative.OnlineShopping.orders;

import Educative.OnlineShopping.enums.OrderStatus;

import java.time.LocalDate;

public class OrderLog {
    private String orderNumber;
    private LocalDate creationDate;
    private OrderStatus status;

    public OrderLog(String orderNumber, OrderStatus status) {
        this.orderNumber = orderNumber;
        this.status = status;
        this.creationDate = LocalDate.now();
    }

    public String getOrderNumber() { return orderNumber; }
    public LocalDate getCreationDate() { return creationDate; }
    public OrderStatus getStatus() { return status; }
}
