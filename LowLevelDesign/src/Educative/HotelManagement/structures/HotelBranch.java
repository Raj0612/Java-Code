package Educative.HotelManagement.structures;


import Educative.HotelManagement.accounts.Address;

import java.util.ArrayList;
import java.util.List;

public class HotelBranch {
    private String name;
    private Address location;
    private List<Room> rooms = new ArrayList<>();

    public HotelBranch(String name, Address addr) {
        this.name = name; this.location = addr;
    }
    public void addRoom(Room room) {
        rooms.add(room);
    }
    public List<Room> getRooms() {
        return rooms;
    }
    public String getName() {
        return name;
    }
}
