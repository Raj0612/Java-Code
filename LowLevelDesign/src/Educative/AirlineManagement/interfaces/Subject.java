package Educative.AirlineManagement.interfaces;

//Implemented by FlightInstance
public interface Subject {
    void attach(Observer observer);
    void detach(Observer observer);
    void notifyObservers(String message);
}
