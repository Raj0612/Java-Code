package Educative.CarRentalSyatem.features;

import Educative.CarRentalSyatem.account.Address;

import java.util.List;

public class CarRentalBranch {
    private String name;
    private Address address;
    private List<ParkingStall> stalls;

    public CarRentalBranch(String name, Address address, List<ParkingStall> stalls) {
        this.name = name;
        this.address = address;
        this.stalls = stalls;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<ParkingStall> getStalls() {
        return stalls;
    }

    public void setStalls(List<ParkingStall> stalls) {
        this.stalls = stalls;
    }
}
