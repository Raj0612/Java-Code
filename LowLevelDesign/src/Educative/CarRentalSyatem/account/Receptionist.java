package Educative.CarRentalSyatem.account;

import Educative.CarRentalSyatem.enums.AccountStatus;

import java.time.LocalDate;
import java.util.*;

public class Receptionist extends Account {
    private LocalDate dateJoined;
    private List<Customer> customerList = new ArrayList<>();

    public Receptionist() {
    }

    public Receptionist(String accountId, String password, AccountStatus status,
                        String name, Address address, String email, String phoneNumber,
                        LocalDate dateJoined) {
        super(accountId, password, status, name, address, email, phoneNumber);
        this.dateJoined = dateJoined;
    }

    public void addCustomer(Customer customer) {
        customerList.add(customer);
    }

    public boolean removeCustomer(Customer customer) {
        return customerList.remove(customer);
    }

    public Customer searchCustomerById(String accountId) {
        for (Customer c : customerList) {
            if (c.getAccountId().equals(accountId)) {
                return c;
            }
        }
        return null;
    }

    @Override
    public boolean resetPassword() {
        this.setPassword(UUID.randomUUID().toString());
        return true;
    }
    public LocalDate getDateJoined() {
        return dateJoined;
    }

    public void setDateJoined(LocalDate dateJoined) {
        this.dateJoined = dateJoined;
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }


}
