package com.leetcode.systemdesign.foodKart;

public class OrderDetails {

    private String userId;
    private String restaurantName;
    private int quantity;
    public String status;
    public OrderDetails(String userId, String restaurantName, int quantity) {
        this.userId = userId;
        this.restaurantName = restaurantName;
        this.quantity = quantity;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
