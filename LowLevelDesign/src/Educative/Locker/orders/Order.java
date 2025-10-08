package Educative.Locker.orders;

import java.util.List;

public class Order {
    private String orderId;
    private List<Item> items;
    private String deliveryLocation;

    public Order(String orderId, List<Item> items, String deliveryLocation) {
        this.orderId = orderId;
        this.items = items;
        this.deliveryLocation = deliveryLocation;
    }

    public String getDeliveryLocation() {
        return deliveryLocation;
    }

    public void setDeliveryLocation(String deliveryLocation) {
        this.deliveryLocation = deliveryLocation;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
}
