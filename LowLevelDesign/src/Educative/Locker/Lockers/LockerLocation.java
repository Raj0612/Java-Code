package Educative.Locker.Lockers;

import java.util.Date;
import java.util.List;

public class LockerLocation {
    private String name;
    private List<Locker> lockers;
    private double longitude;
    private double latitude;
    private Date openTime;
    private Date closeTime;

    public LockerLocation(String name, List<Locker> lockers, double longitude, double latitude, Date openTime, Date closeTime) {
        this.name = name;
        this.lockers = lockers;
        this.longitude = longitude;
        this.latitude = latitude;
        this.openTime = openTime;
        this.closeTime = closeTime;
    }

    public void addLocker(Locker locker) {
        this.lockers.add(locker);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Locker> getLockers() {
        return lockers;
    }

    public void setLockers(List<Locker> lockers) {
        this.lockers = lockers;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public Date getOpenTime() {
        return openTime;
    }

    public void setOpenTime(Date openTime) {
        this.openTime = openTime;
    }

    public Date getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(Date closeTime) {
        this.closeTime = closeTime;
    }
}
