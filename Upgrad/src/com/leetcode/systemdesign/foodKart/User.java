package com.leetcode.systemdesign.foodKart;

import java.util.ArrayList;
import java.util.List;

public class User {

    private String name;
    private String gender;
    private String phoneNumber;
    private String pinCode;

    public List<OrderDetails> orderHistory;
    public User(String name, String gender, String phoneNumber, String pinCode) {
        this.name = name;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.pinCode = pinCode;
        orderHistory = new ArrayList<>();
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public List<OrderDetails> getOrderHistory() {
        return orderHistory;
    }

    public void setOrderHistory(OrderDetails order) {
        orderHistory.add(order);
    }
}
