package DesignPatterns.Structural.Proxy.customer;

import java.util.List;

public interface Customer {

    int getId();
    List<CustomerOrder> getOrders();
}
