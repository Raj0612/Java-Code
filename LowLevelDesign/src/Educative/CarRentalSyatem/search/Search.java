package Educative.CarRentalSyatem.search;

import Educative.CarRentalSyatem.vehicle.Vehicle;

import java.util.List;

public interface Search {
    public List<Vehicle> searchByType(String type);
    public List<Vehicle> searchByModel(String model);
}
