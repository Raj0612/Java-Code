package Educative.Locker.Lockers;

import Educative.Locker.enums.LockerSize;
import Educative.Locker.enums.LockerState;

import java.util.UUID;

public class Locker {
    private String lockerId;
    private LockerSize lockerSize;
    private String locationId;
    private LockerState lockerState;
    private Package package1;

    public Locker(LockerSize lockerSize, String locationId, LockerState lockerState) {
        this.lockerId = UUID.randomUUID().toString();
        this.lockerSize = lockerSize;
        this.locationId = locationId;
        this.lockerState = LockerState.AVAILABLE;
    }

    public boolean addPackage(Package package1){
        this.package1 = package1;
        lockerState = LockerState.BOOKED;
        return true;
    }
    public boolean removePackage(){
        this.package1 = null;
        lockerState = LockerState.AVAILABLE;
        return true;
    }

    public String getLockerId() {
        return lockerId;
    }

    public LockerSize getLockerSize() {
        return lockerSize;
    }

    public void setLockerSize(LockerSize lockerSize) {
        this.lockerSize = lockerSize;
    }

    public String getLocationId() {
        return locationId;
    }

    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }

    public LockerState getLockerState() {
        return lockerState;
    }

    public void setLockerState(LockerState lockerState) {
        this.lockerState = lockerState;
    }
}
