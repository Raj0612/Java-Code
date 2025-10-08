package Educative.Locker.service;

import Educative.Locker.Lockers.LockerLocation;

import java.util.List;

public class LockerService {
    private List<LockerLocation> locations;
    private static LockerService lockerService = null;

    public static LockerService getInstance() {
        if (lockerService == null) {
            lockerService = new LockerService();
        }
        return lockerService;
    }

    public void addLockerLocation(LockerLocation lockerLocation) {
        this.locations.add(lockerLocation);
    }

    public List<LockerLocation> getLocations() {
        return locations;
    }

    public void setLocations(List<LockerLocation> locations) {
        this.locations = locations;
    }
}
