package DesignPatterns.Creational.Builder.car.builder;

import DesignPatterns.Creational.Builder.car.Engine;
import DesignPatterns.Creational.Builder.car.GPSNavigator;
import DesignPatterns.Creational.Builder.car.TripComputer;
import DesignPatterns.Creational.Builder.car.enums.CarType;
import DesignPatterns.Creational.Builder.car.enums.Transmission;

public interface Builder {
    void setCarType(CarType type);
    void setSeats(int seats);
    void setEngine(Engine engine);
    void setTransmission(Transmission transmission);
    void setTripComputer(TripComputer tripComputer);
    void setGPSNavigator(GPSNavigator gpsNavigator);
}
