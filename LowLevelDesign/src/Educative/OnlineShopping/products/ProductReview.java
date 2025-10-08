package Educative.OnlineShopping.products;

import Educative.OnlineShopping.accounts.AuthenticatedUser;

public class ProductReview {
    private int rating;
    private String review;
    private byte[] image;
    private AuthenticatedUser user;

    public ProductReview(int rating, String review, AuthenticatedUser user) {
        this.rating = rating;
        this.review = review;
        this.user = user;
    }

    public int getRating() {
        return rating;
    }
    public String getReview() {
        return review;
    }
    public AuthenticatedUser getUser() {
        return user;
    }
}
