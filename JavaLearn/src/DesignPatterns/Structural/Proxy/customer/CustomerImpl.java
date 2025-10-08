package DesignPatterns.Structural.Proxy.customer;

import java.util.List;

public class CustomerImpl implements Customer{

    private int id;
    private List<CustomerOrder> orders;

    public CustomerImpl(){
        this.id = 123;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int getId() {
        return id;
    }

    public void setOrders(List<CustomerOrder> orders) {
        this.orders = orders;
    }
    @Override
    public List<CustomerOrder> getOrders() {
        return orders;
    }
}
