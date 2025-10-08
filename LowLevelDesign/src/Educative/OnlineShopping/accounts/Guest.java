package Educative.OnlineShopping.accounts;

import Educative.OnlineShopping.carts.ShoppingCart;

public class Guest extends Customer {
    public Guest() {
        this.cart = new ShoppingCart();
    }

    public boolean registerAccount() {
        System.out.println("Guest registering a new account...");
        return true;
    }

    public ShoppingCart getShoppingCart() {
        return cart;
    }
}