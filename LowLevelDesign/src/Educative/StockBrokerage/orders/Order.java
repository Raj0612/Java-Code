package Educative.StockBrokerage.orders;

import Educative.StockBrokerage.accounts.Member;
import Educative.StockBrokerage.enums.*;
import Educative.StockBrokerage.notifications.*;
import Educative.StockBrokerage.stocks.Stock;

import java.time.LocalDate;
import java.util.*;

public abstract class Order {
    private static int counter = 1;
    private String orderNumber;
    private boolean isBuyOrder;
    private OrderStatus status;
    private TimeEnforcementType timeEnforcement;
    private LocalDate creationTime;
    private Map<Integer, OrderPart> parts;
    private double quantity;
    private double limitPrice;
    private Member member;
    private Stock stock;

    public Order(Member member, Stock stock, double quantity, double limitPrice, TimeEnforcementType timeEnforcement, boolean isBuyOrder) {
        this.orderNumber = "ORD" + (counter++);
        this.member = member;
        this.stock = stock;
        this.quantity = quantity;
        this.limitPrice = limitPrice;
        this.timeEnforcement = timeEnforcement;
        this.isBuyOrder = isBuyOrder;
        this.status = OrderStatus.OPEN;
        this.creationTime = LocalDate.now();
        this.parts = new HashMap<>();
    }

    public String getOrderNumber() { return orderNumber; }
    public boolean isBuyOrder() { return isBuyOrder; }
    public OrderStatus getStatus() { return status; }
    public void setStatus(OrderStatus status) { this.status = status; }
    public Stock getStock() { return stock; }
    public double getLimitPrice() { return limitPrice; }
    public double getQuantity() { return quantity; }
    public Member getMember() { return member; }

    public boolean saveInDatabase() {
        // Simulate DB save
        return true;
    }
    public void addOrderPart(OrderPart part) {
        parts.put(parts.size(), part);
    }
    public void execute() {
        // Logic for execution, update status, notify member, update positions/funds
        setStatus(OrderStatus.FILLED);
        // Notification
        Notification notification = new EmailNotification(member.getEmail(), "Order " + orderNumber + " executed.");
        notification.sendNotification();
    }
}
