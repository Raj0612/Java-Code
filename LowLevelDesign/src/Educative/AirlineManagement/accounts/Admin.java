package Educative.AirlineManagement.accounts;

import Educative.AirlineManagement.Airline;
import Educative.AirlineManagement.airports.*;
import Educative.AirlineManagement.enums.AccountStatus;

public class Admin extends Person {
    public Admin(String name, Address address, String email, String phone, Account account) {
        super(name, address, email, phone, account);
    }

    public boolean addAircraft(Aircraft aircraft) {
        return Airline.getInstance().addAircraft(aircraft);
    }

    public boolean addFlight(Flight flight) {
        return Airline.getInstance().addFlight(flight);
    }

    public boolean cancelFlight(Flight flight) {
        return Airline.getInstance().cancelFlight(flight);
    }

    public boolean assignCrew(FlightInstance instance, Crew crew) {
        return instance.assignCrew(crew);
    }

    public boolean blockUser(Account account) {
        account.setStatus(AccountStatus.BLOCKED);
        return true;
    }

    public boolean unblockUser(Account account) {
        account.setStatus(AccountStatus.ACTIVE);
        return true;
    }
}