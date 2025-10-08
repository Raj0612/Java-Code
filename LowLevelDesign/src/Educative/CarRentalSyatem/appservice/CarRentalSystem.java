package Educative.CarRentalSyatem.appservice;

import Educative.CarRentalSyatem.features.CarRentalBranch;

import java.util.*;

public class CarRentalSystem {
    private String name;
    private List<CarRentalBranch> branches = new ArrayList<>();
    private static CarRentalSystem system = null;

    private CarRentalSystem() {
    }

    public static CarRentalSystem getInstance() {
        if (system == null) {
            system = new CarRentalSystem();
        }
        return system;
    }

    public void addNewBranch(CarRentalBranch branch) {
        branches.add(branch);
    }

    public List<CarRentalBranch> getBranches() {
        return branches;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
