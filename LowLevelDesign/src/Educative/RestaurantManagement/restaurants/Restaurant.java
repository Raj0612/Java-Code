package Educative.RestaurantManagement.restaurants;

import Educative.RestaurantManagement.accounts.Employee;

import java.util.*;

public class Restaurant {
    private static Restaurant instance;
    private String name;
    private List<Branch> branches;
    private List<Employee> employees;

    public Restaurant() {
        this.branches = new ArrayList<>();
        this.employees = new ArrayList<>();
    }

    public static synchronized Restaurant getInstance() {
        if (instance == null) {
            instance = new Restaurant();
        }
        return instance;
    }


    public boolean addBranch(Branch branch) {
        branches.add(branch);
        return true;
    }

    public boolean addEmployee(Employee employee) {
        employees.add(employee);
        return true;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Branch> getBranches() {
        return branches;
    }

    public void setBranches(List<Branch> branches) {
        this.branches = branches;
    }

    public String toString() {
        return "Restaurant{" +
                "name='" + name + '\'' +
                ", branches=" + branches +
                '}';
    }
}
