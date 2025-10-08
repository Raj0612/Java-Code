package Educative.CarRentalSyatem.search;

import Educative.CarRentalSyatem.vehicle.Vehicle;

import java.util.*;

public class VehicleCatalog implements Search {
    private Map<String, List<Vehicle>> vehicleTypes = new HashMap<>();
    private Map<String, List<Vehicle>> vehicleModels = new HashMap<>();

    public void addVehicle(Vehicle vehicle) {
        vehicleTypes.computeIfAbsent(vehicle.getClass().getSimpleName().toUpperCase(), k -> new ArrayList<>()).add(vehicle);
        vehicleModels.computeIfAbsent(vehicle.getModel().toUpperCase(), k -> new ArrayList<>()).add(vehicle);
    }

    @Override
    public List<Vehicle> searchByType(String type) {
        return vehicleTypes.getOrDefault(type.toUpperCase(), Collections.emptyList());
    }

    @Override
    public List<Vehicle> searchByModel(String model) {
        return vehicleModels.getOrDefault(model.toUpperCase(), Collections.emptyList());
    }
}
