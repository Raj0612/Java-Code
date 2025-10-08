package LowLevelDesign.GeekForGeeks.DesignAirlineBooking;

import LowLevelDesign.GeekForGeeks.DesignAirlineBooking.enums.ClassType;
import LowLevelDesign.GeekForGeeks.DesignAirlineBooking.enums.SeatCategory;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Timer;

public class AirlineBookingSystem {

    private final ArrayList<Airport> airports;
    private final ArrayList<Flight> flights;

    private HashMap<String, ArrayList<Flight>> flightMap;

    public AirlineBookingSystem(ArrayList<Airport> airports, ArrayList<Flight> flights) {
        this.airports = airports;
        this.flights = flights;
        this.flightMap = new HashMap<>();

        generateFlightMap();
    }
    private void generateFlightMap(){
        for(Flight flight:flights){
            if(flightMap.containsKey(flight.getDestination())){
                flightMap.get(flight.getDestination()).add(flight);
            }else{
                ArrayList<Flight> flightList = new ArrayList<>();
                flightList.add(flight);
                this.flightMap.put(flight.getDestination(), flightList);
            }
        }
    }

    //customer can search a flight
    public ArrayList<Flight> searchFlights(String destination) throws Exception{
        if(this.flightMap.containsKey(destination)){
            return this.flightMap.get(destination);
        }else{
            throw new Exception("Flights not found for the destination");
        }
    }

    public Reservation bookFlight(LocalDateTime creationDate, Flight flight, Seat seats, Airport destinationAirport, Airport sourceAirport, Customer customer, int numberOfseats) throws Exception{

        if(numberOfseats > flight.getAircraft().getSeats()){
            throw new Exception("No Seats Available");
        }

        int remainingSeats = flight.getAircraft().getSeats() - numberOfseats;
        flight.getAircraft().setSeats(remainingSeats);
        return new Reservation(creationDate, flight, seats, destinationAirport,sourceAirport,customer);
    }


    public static void main(String[] args){

        Address address = new Address("FoyerCity", "Ecity", "Ecity","BLR", "KA", "INDIA" );
        Address goaAirportAddress = new Address("Goa Airport", "Ecity1", "Ecity","GOA", "GOA", "INDIA" );
        Address delhiAirportAddress = new Address("Delhi Airport", "Ecity2", "Ecity","Delhi", "Delhi", "INDIA" );
        Address staffAddress = new Address("FoyerCity", "Ecity3", "Ecity","BLR", "KA", "INDIA" );

        //passport
        Passport rajPassport = new Passport("1234", "6/12/1986", address,"23/12/2025");
        Passport staffPassport = new Passport("123445", "6/12/1986", staffAddress,"23/12/2025");

        //User
        Customer raj = new Customer("1", "pass", "Raj", "email", "123456", rajPassport);
        Customer staff = new Customer("1", "pass", "Staff", "email", "123456ss", staffPassport);

        //Aicraft
        Aircraft indigo = new Aircraft("Indigo", "2", "2024", 36);
        Aircraft airIndia = new Aircraft("Air India", "8", "2025", 36);
        ArrayList<Aircraft> aircrafts = new ArrayList<>();
        aircrafts.add(indigo);
        aircrafts.add(airIndia);

        //Airport
        Airport goaAirport = new Airport("Goa Airport", goaAirportAddress, 1, aircrafts);
        Airport delhiAirport = new Airport("Delhi Airport", delhiAirportAddress, 2, aircrafts);

        //Flight
        LocalDateTime arrival = LocalDateTime.of(2023, 4, 10, 9, 50, 40);
        LocalDateTime arrival2 = LocalDateTime.of(2023, 4, 10, 10, 50, 40);
        LocalDateTime departure = LocalDateTime.of(2023, 4, 10, 11, 50, 40);
        LocalDateTime departure2 = LocalDateTime.of(2023, 4, 10, 12, 50, 40);

        Flight delhiToGoaFlight = new Flight(departure,arrival, new Timer("120"), "DELHI", "GOA", indigo);
        Flight goaToDelhiFlight = new Flight(departure2,arrival2, new Timer("120"), "GOA", "DELHI", indigo);

        ArrayList<Airport> airports = new ArrayList<>();
        airports.add(goaAirport);
        airports.add(delhiAirport);

        ArrayList<Flight> fligts = new ArrayList<>();
        fligts.add(delhiToGoaFlight);
        fligts.add(goaToDelhiFlight);



        AirlineBookingSystem airlineBookingSystem = new AirlineBookingSystem(airports, fligts);

        //Search A Flight
        try{
            ArrayList<Flight> goaFlights = airlineBookingSystem.searchFlights("GOA");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

       // Book a Flight
        try{
            ArrayList<Flight> goaFlights = airlineBookingSystem.searchFlights("GOA");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }


        try{
            Reservation reservation = airlineBookingSystem.bookFlight(LocalDateTime.now(), delhiToGoaFlight, new Seat(5, ClassType.BUSINESSCLASS, SeatCategory.REGULAR),
                    goaAirport,delhiAirport,raj, 10);
            System.out.println("Flight Booked Successfully");
            System.out.println("reservation " + reservation);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}
