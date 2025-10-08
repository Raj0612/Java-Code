package Educative.VendingMachine.subjects;


import java.util.*;

public class Rack {
    private final int rackNumber;
    private final Queue<Product> products;

    public Rack(int rackNumber) {
        this.rackNumber = rackNumber;
        this.products = new LinkedList<>();
    }

    public int getRackNumber() {
        return rackNumber;
    }

    public boolean isEmpty() {
        return products.isEmpty();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public Product removeProduct() {
        return products.poll();
    }

    public Product peekProduct() {
        return products.peek();
    }
}
