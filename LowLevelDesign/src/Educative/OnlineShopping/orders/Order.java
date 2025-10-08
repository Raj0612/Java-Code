package Educative.OnlineShopping.orders;

import Educative.OnlineShopping.carts.ShoppingCart;
import Educative.OnlineShopping.enums.OrderStatus;
import Educative.OnlineShopping.enums.PaymentStatus;
import Educative.OnlineShopping.payments.Payment;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private String orderNumber;
    private OrderStatus status;
    private LocalDate orderDate;
    private List<OrderLog> orderLog;
    private ShoppingCart shoppingCart;

    public Order(String orderNumber, ShoppingCart shoppingCart) {
        this.orderNumber = orderNumber;
        this.shoppingCart = shoppingCart;
        this.status = OrderStatus.UNSHIPPED;
        this.orderDate = LocalDate.now();
        this.orderLog = new ArrayList<>();
    }

    public boolean sendForShipment() {
        System.out.println("Order '" + orderNumber + "' sent for shipment.");
        this.status = OrderStatus.PENDING;
        return true;
    }

    public boolean makePayment(Payment payment) {
        PaymentStatus result = payment.makePayment();
        if (result == PaymentStatus.CONFIRMED) {
            System.out.println("Payment confirmed for order '" + orderNumber + "'.");
            return true;
        } else {
            System.out.println("Payment failed for order '" + orderNumber + "'.");
            return false;
        }
    }

    public boolean addOrderLog(OrderLog log) {
        orderLog.add(log);
        System.out.println("Order log added for order '" + orderNumber + "'.");
        return true;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public List getOrderLog() {
        return orderLog;
    }

    public void setOrderLog(List orderLog) {
        this.orderLog = orderLog;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }
}
