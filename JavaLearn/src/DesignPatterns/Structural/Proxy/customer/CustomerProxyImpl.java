package DesignPatterns.Structural.Proxy.customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerProxyImpl implements Customer{

    Customer customer = new CustomerImpl();
    @Override
    public int getId() {
        return customer.getId();
    }

    @Override
    public List<CustomerOrder> getOrders() {
       List<CustomerOrder> lists = new ArrayList<>();
        CustomerOrder order1= new CustomerOrder();
        order1.setId(1);
        order1.setProductName("Apple");
        order1.setQuantity(2);
       lists.add(order1);
        CustomerOrder order2= new CustomerOrder();
        order1.setId(2);
        order1.setProductName("Samsung");
        order1.setQuantity(2);
        lists.add(order2);
        return lists;
    }
}
