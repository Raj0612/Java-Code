package Educative.AirlineManagement;
import Educative.AirlineManagement.accounts.*;
import Educative.AirlineManagement.airports.*;
import Educative.AirlineManagement.enums.*;
import Educative.AirlineManagement.payments.*;
import Educative.AirlineManagement.search.SearchCatalog;
import Educative.AirlineManagement.seats.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class AirlineManagementDemo {
    public static void main(String[] args) {
        // --- SETUP: Create addresses, airports, aircraft, seats ---
        Address addr1 = new Address(12345, "1 Main St", "Metropolis", "State", "Country");
        Address addr2 = new Address(67890, "2 Elm St", "Gotham", "State", "Country");
        Airport airportA = new Airport("Metropolis International", "MET", addr1);
        Airport airportB = new Airport("Gotham Airport", "GTH", addr2);

        List<Seat> aircraftSeats = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            aircraftSeats.add(new Seat("A" + i, SeatType.REGULAR, SeatClass.ECONOMY));
        }

        for (int i = 11; i <= 15; i++) {
            aircraftSeats.add(new Seat("B" + i, SeatType.EXTRA_LEG_ROOM, SeatClass.BUSINESS));
        }
        Aircraft aircraft1 = new Aircraft("Boeing 737", "B737", "737-800", 10, aircraftSeats);

        // --- ADMIN: Add aircraft and flights ---
        Account adminAcc = new Account(1, "admin", "adminpass", AccountStatus.ACTIVE);
        Admin admin = new Admin("Alice Admin", addr1, "admin@airline.com", "1234567890", adminAcc);

        admin.addAircraft(aircraft1);

        Flight flight1 = new Flight("FL100", 120, airportA, airportB);
        admin.addFlight(flight1);

        // --- Create flight instance ---
        List<FlightSeat> flightSeats = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            flightSeats.add(new FlightSeat("A" + i, SeatType.REGULAR, SeatClass.ECONOMY, 100.0));
        }
        for (int i = 11 ;i <= 15; i++) {
            flightSeats.add(new FlightSeat("B" + i, SeatType.EXTRA_LEG_ROOM, SeatClass.BUSINESS, 500.0));
        }
        FlightInstance instance1 = new FlightInstance(flight1, LocalDateTime.of(2025, 7, 1, 10, 0),
                "G1", FlightStatus.SCHEDULED, aircraft1, flightSeats);
        flight1.addInstance(instance1);

        // --- CREW: Assign crew to flight ---
        Account crewAcc = new Account(2, "crew", "crewpass", AccountStatus.ACTIVE);
        Crew crew = new Crew("Charlie Crew", addr2, "crew@airline.com", "5551234567", crewAcc);
        admin.assignCrew(instance1, crew);

        // --- CUSTOMER: Create customer and passengers ---
        Account custAcc = new Account(3, "john_doe", "custpass", AccountStatus.ACTIVE);
        Customer customer = new Customer("John Doe", addr1, "john@example.com", "1112223333", custAcc, 1001);

        Passenger passenger1 = new Passenger(1, "John Doe", "M", LocalDate.of(1990, 1, 1), "P1234567");
        Passenger passenger2 = new Passenger(2, "Mrs. Jane Doe", "F", LocalDate.of(1992, 2, 2), "P7654321");

        // --- CUSTOMER: Search for flights ---
        List<FlightInstance> availableFlights = new SearchCatalog(Arrays.asList(instance1))
                .searchFlight(airportA, airportB, LocalDate.of(2025, 7, 1));
        System.out.println("Available flights found: " + availableFlights.size());

        // --- CUSTOMER: Create itinerary and reservation ---
        Itinerary itinerary = new Itinerary(airportA, airportB, LocalDate.now(), Arrays.asList(passenger1, passenger2));
        customer.createItinerary(itinerary);

        FlightReservation reservation = new FlightReservation("R1001", instance1, LocalDate.now());
        itinerary.addReservation(reservation);

        // --- CUSTOMER: Assign seats ---
        customer.assignSeat(reservation, passenger1, flightSeats.get(0));
        customer.assignSeat(reservation, passenger2, flightSeats.get(1));

        // --- CUSTOMER: Make payment ---
        Payment payment = PaymentFactory.createPayment("CreditCard", 1, 200.0, "John Doe", "4111111111111111");
        customer.makePayment(itinerary, payment);

        // --- CUSTOMER: Register for notifications (Observer) ---
        instance1.attach(customer);

        // --- ADMIN: Update flight status and notify customers ---
        admin.addFlight(flight1); // Redundant, but shows method
        instance1.updateStatus(FlightStatus.DELAYED); // Should notify customer

        // --- CUSTOMER: Cancel reservation ---
        reservation.setStatus(ReservationStatus.CANCELED);
        instance1.notifyObservers("Your reservation " + reservation.getReservationNumber() + " has been canceled.");

        // --- FRONT DESK OFFICER: Book and pay for customer ---
        Account fdoAcc = new Account(4, "fdo", "fdopass", AccountStatus.ACTIVE);
        FrontDeskOfficer fdo = new FrontDeskOfficer("Fiona FDO", addr2, "fdo@airline.com", "9998887777", fdoAcc);

        // Create new itinerary for another customer
        Account cust2Acc = new Account(5, "mary_smith", "pass123", AccountStatus.ACTIVE);
        Customer customer2 = new Customer("Mary Smith", addr2, "mary@example.com", "4445556666", cust2Acc, 1002);
        Passenger passenger3 = new Passenger(3, "Mary Smith", "F", LocalDate.of(1985, 5, 5), "P3332221");
        Itinerary itinerary2 = new Itinerary(airportA, airportB, LocalDate.now(), Arrays.asList(passenger3));
        fdo.createItinerary(customer2, itinerary2);

        FlightReservation reservation2 = new FlightReservation("R1002", instance1, LocalDate.now());
        fdo.createReservation(itinerary2, reservation2);
        fdo.assignSeat(reservation2, passenger3, flightSeats.get(2));
        Payment cashPayment = PaymentFactory.createPayment("Cash", 2, 100.0);
        fdo.makePayment(itinerary2, cashPayment);

        // --- CREW: View assigned schedule ---
        List<FlightInstance> crewSchedule = crew.viewSchedule();
        System.out.println("Crew assigned to " + crewSchedule.size() + " flight(s).");

        // --- ADMIN: Block and unblock a user ---
        admin.blockUser(cust2Acc);
        System.out.println("Customer 2 status after block: " + cust2Acc.getStatus());
        admin.unblockUser(cust2Acc);
        System.out.println("Customer 2 status after unblock: " + cust2Acc.getStatus());

        // --- ADMIN: Cancel a flight ---
        admin.cancelFlight(flight1);
        System.out.println("Flights in system after cancel: " + Airline.getInstance().getFlights().size());

        // --- ADMIN: Add an aircraft ---
        admin.addAircraft(aircraft1);
        System.out.println("Aircrafts in system after add: " + Airline.getInstance().getAirCrafts().size());

        // --- ADMIN: Add a crew ---
        admin.assignCrew(instance1, crew);
        System.out.println("Crew in system after add: " + Airline.getInstance().getCrew().size());

        // --- ADMIN: Add a flight ---
        admin.addFlight(flight1);
        System.out.println("Flights in system after add: " + Airline.getInstance().getFlights().size());
    }
}
