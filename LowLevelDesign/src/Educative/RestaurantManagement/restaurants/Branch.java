package Educative.RestaurantManagement.restaurants;

import Educative.RestaurantManagement.accounts.Address;
import Educative.RestaurantManagement.accounts.Employee;
import Educative.RestaurantManagement.meals.Kitchen;
import Educative.RestaurantManagement.menus.Menu;
import Educative.RestaurantManagement.tables.Table;

import java.util.*;

public class Branch {
    private String name;
    private Address location;
    private Kitchen kitchen;
    private Menu menu;
    private SeatingChart seatingChart;
    private List<Table> tables;
    private List<Employee> employees;

    public Branch(String name, Address location, Kitchen kitchen, Menu menu) {
        this.name = name;
        this.location = location;
        this.kitchen = kitchen;
        this.menu = menu;
        this.tables = new ArrayList<>();
        this.employees = new ArrayList<>();
    }

    public Address addSeatingChart(SeatingChart chart) {
        this.seatingChart = chart;
        return location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getLocation() {
        return location;
    }

    public void setLocation(Address location) {
        this.location = location;
    }

    public Kitchen getKitchen() {
        return kitchen;
    }

    public void setKitchen(Kitchen kitchen) {
        this.kitchen = kitchen;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public SeatingChart getSeatingChart() {
        return seatingChart;
    }

    public void setSeatingChart(SeatingChart seatingChart) {
        this.seatingChart = seatingChart;
    }

    public List<Table> getTables() {
        return tables;
    }

    public void setTables(List<Table> tables) {
        this.tables = tables;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public boolean addEmployee(Employee employee) {
        employees.add(employee);
        return true;
    }

    public  boolean removeEmployee(Employee employee) {
        employees.remove(employee);
        return true;
    }

    public String toString() {
        return "Branch{" +
                "name='" + name + '\'' +
                ", location=" + location +
                ", kitchen=" + kitchen +
                ", menu=" + menu +
                ", seatingChart=" + seatingChart +
                ", tables=" + tables +
                ", employees=" + employees +
                '}';
    }
}
