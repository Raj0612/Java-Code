package Educative.AirlineManagement.search;

import Educative.AirlineManagement.airports.*;

import java.time.LocalDate;
import java.util.List;

public interface Search {
    List<FlightInstance> searchFlight(Airport source, Airport dest, LocalDate date);
}
