package DesignPatterns.Structural.Proxy.customer;

public class Client {

    public static void main(String[] args) {
        Customer customer = new CustomerProxyImpl();
        System.out.println("ID " + customer.getId());
        System.out.println("Orders " + customer.getOrders());
    }
}
