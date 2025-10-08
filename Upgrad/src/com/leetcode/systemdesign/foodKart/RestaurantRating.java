package com.leetcode.systemdesign.foodKart;

public class RestaurantRating {

    int rating;

    String userId;

    String restaurantName;

    String Comment;

    public RestaurantRating(int rating, String userId, String restaurantName, String comment) {
        this.rating = rating;
        this.userId = userId;
        this.restaurantName = restaurantName;
        Comment = comment;
    }
}
