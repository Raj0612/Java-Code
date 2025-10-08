package Educative.AirlineManagement;

import Educative.AirlineManagement.accounts.*;
import Educative.AirlineManagement.airports.*;

import java.util.*;

public class Airline {
    private String name;
    private String code;
    private List<Flight> flights;
    private List<Aircraft> airCrafts;
    private List<Crew> crew;

    private static Airline airline = null;

    private Airline() {
        flights = new ArrayList<>();
        airCrafts = new ArrayList<>();
        crew = new ArrayList<>();
    }

    public static Airline getInstance() {
        if (airline == null) {
            airline = new Airline();
        }
        return airline;
    }

    public boolean addAircraft(Aircraft aircraft) {
        return airCrafts.add(aircraft);
    }

    public boolean addFlight(Flight flight) {
        return flights.add(flight);
    }

    public boolean cancelFlight(Flight flight) {
        return flights.remove(flight);
    }

    public List<Flight> getFlights() {
        return flights;
    }

    public void setFlights(List<Flight> flights) {
        this.flights = flights;
    }

    public List<Aircraft> getAirCrafts() {
        return airCrafts;
    }

    public void setAirCrafts(List<Aircraft> airCrafts) {
        this.airCrafts = airCrafts;
    }

    public List<Crew> getCrew() {
        return crew;
    }

    public void setCrew(List<Crew> crew) {
        this.crew = crew;
    }

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
}
