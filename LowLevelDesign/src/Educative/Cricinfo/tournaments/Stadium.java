package Educative.Cricinfo.tournaments;

import Educative.Cricinfo.accounts.Address;

import java.util.UUID;

public class Stadium {
    private final UUID id;
    private String name;
    private Address location;
    private int maxCapacity;

    public Stadium(String name, Address location, int maxCapacity) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.location = location;
        this.maxCapacity = maxCapacity;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Address getLocation() {
        return location;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(Address location) {
        this.location = location;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }
}
