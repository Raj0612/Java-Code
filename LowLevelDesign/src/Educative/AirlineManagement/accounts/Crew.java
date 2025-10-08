package Educative.AirlineManagement.accounts;

import Educative.AirlineManagement.airports.FlightInstance;

import java.util.*;

public class Crew extends Person {
    private List<FlightInstance> assignedFlights = new ArrayList<>();

    public Crew(String name, Address address, String email, String phone, Account account) {
        super(name, address, email, phone, account);
    }

    public List<FlightInstance> viewSchedule() {
        return assignedFlights;
    }

    public void assignFlight(FlightInstance instance) {
        assignedFlights.add(instance);
    }

    public void removeFlight(FlightInstance instance) {
        assignedFlights.remove(instance);
    }
}
