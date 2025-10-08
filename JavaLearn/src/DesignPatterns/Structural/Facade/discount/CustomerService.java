package DesignPatterns.Structural.Facade.discount;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class CustomerService {

    private Map<Long, Customer> customers = new HashMap<>();

    public CustomerService() {
        customers.put(1L, new Customer("Vader", "Imperial City",
                new Date()));
    }

    public Customer findProductBy(long idCustomer) {
        return customers.get(idCustomer);
    }


}
