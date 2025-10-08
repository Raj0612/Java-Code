package Educative.OnlineShopping.carts;

import Educative.OnlineShopping.products.Product;

public class CartItem {
    private int quantity;
    private double price;
    private Product product;

    public CartItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
        this.price = product.getPrice();
    }

    public boolean updateQuantity(int quantity) {
        if (quantity > 0) {
            this.quantity = quantity;
            System.out.println("Quantity for product '" + product.getName() + "' updated to " + quantity);
            return true;
        }
        System.out.println("Invalid quantity specified for product '" + product.getName() + "'.");
        return false;
    }

    public int getQuantity() { return quantity; }
    public double getPrice() { return price; }
    public Product getProduct() { return product; }
}
