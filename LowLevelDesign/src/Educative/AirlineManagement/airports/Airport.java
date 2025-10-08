package Educative.AirlineManagement.airports;

import Educative.AirlineManagement.accounts.*;

import java.util.*;

public class Airport {
    private String name;
    private String code;
    private Address address;
    private List<Flight> flights;

    public Airport(String name, String code, Address address) {
        this.name = name;
        this.code = code;
        this.address = address;
        this.flights = new ArrayList<>();
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Flight> getFlights() {
        return flights;
    }

    public void setFlights(List<Flight> flights) {
        this.flights = flights;
    }
}
