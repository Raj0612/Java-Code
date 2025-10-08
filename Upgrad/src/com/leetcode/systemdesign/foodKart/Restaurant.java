package com.leetcode.systemdesign.foodKart;

import java.util.Comparator;
import java.util.List;

public class Restaurant {

    private String name;
    private String foodName;
    private float foodPrice;
    private int quantity;
    private List<String> pinCodes;
    private int ratings = 0;
    public int ratingsCount = 0;
    public int totalRatings = 0;
    public Restaurant(String name, String foodName, float foodPrice, int quantity, List<String> pinCodes) {
        this.name = name;
        this.foodName = foodName;
        this.foodPrice = foodPrice;
        this.quantity = quantity;
        this.pinCodes = pinCodes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public float getFoodPrice() {
        return foodPrice;
    }

    public void setFoodPrice(float foodPrice) {
        this.foodPrice = foodPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public List<String> getPinCodes() {
        return pinCodes;
    }

    public void setPinCodes(List<String> pinCodes) {
        this.pinCodes = pinCodes;
    }

    public int getRatings() {
        return ratings;
    }

    public void setRatings(int ratings) {
        this.ratings = ratings;
    }

    public static class SortByRatings implements Comparator<Restaurant> {

        @Override
        public int compare(Restaurant o1, Restaurant o2) {
            return o1.ratings > o2.ratings ? 1 : (o1.ratings < o2.ratings ? -1 : 0);
        }
    }

    public static class SortByPrice implements Comparator<Restaurant> {

        @Override
        public int compare(Restaurant o1, Restaurant o2) {
            return o1.foodPrice> o2.foodPrice ? 1 : (o1.foodPrice < o2.foodPrice ? -1 : 0);
        }
    }

}
