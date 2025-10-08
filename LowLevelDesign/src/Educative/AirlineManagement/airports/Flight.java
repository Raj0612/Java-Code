package Educative.AirlineManagement.airports;

import java.util.*;

public class Flight {
    private String flightNo;
    private int durationMin;
    private Airport departure;
    private Airport arrival;
    private List<FlightInstance> instances;

    public Flight(String flightNo, int durationMin, Airport departure, Airport arrival) {
        this.flightNo = flightNo;
        this.durationMin = durationMin;
        this.departure = departure;
        this.arrival = arrival;
        this.instances = new ArrayList<>();
    }

    // Getters and setters
    public String getFlightNo() {
        return flightNo;
    }

    public void setFlightNo(String flightNo) {
        this.flightNo = flightNo;
    }

    public int getDurationMin() {
        return durationMin;
    }

    public void setDurationMin(int durationMin) {
        this.durationMin = durationMin;
    }

    public Airport getDeparture() {
        return departure;
    }

    public void setDeparture(Airport departure) {
        this.departure = departure;
    }

    public Airport getArrival() {
        return arrival;
    }

    public void setArrival(Airport arrival) {
        this.arrival = arrival;
    }

    public List<FlightInstance> getInstances() {
        return instances;
    }

    public void setInstances(List<FlightInstance> instances) {
        this.instances = instances;
    }

    public void addInstance(FlightInstance instance) {
        this.instances.add(instance);
    }
}
