package GeekForGeeks.DesignAirlineBooking;

import java.util.ArrayList;
import java.util.List;

public class Staff extends Account {

    private List<Aircraft> aircrafts;

    private List<Flight> flights;
    Staff(String id, String password, String name, String email, String phone, Passport pass){
        super(id, password, name, email, phone, pass);
        this.aircrafts = new ArrayList<>();
        this.flights = new ArrayList<>();
    }

    public void addAircraft(Aircraft aircraft){
        this.aircrafts.add(aircraft);
    }

    public void addFlight(Flight flight){
        this.flights.add(flight);
    }
}
