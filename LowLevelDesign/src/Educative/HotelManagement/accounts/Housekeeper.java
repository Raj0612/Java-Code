package Educative.HotelManagement.accounts;

import Educative.HotelManagement.structures.Room;
import Educative.HotelManagement.services.RoomHousekeeping;

import java.time.LocalDateTime;

public class Housekeeper extends Person {
    public Housekeeper(String name, Address addr, String email, String phone, Account acc) {
        super(name, addr, email, phone, acc);
    }
    public boolean assignToRoom(Room room, String desc, int duration) {
        RoomHousekeeping hk = new RoomHousekeeping(desc, LocalDateTime.now(), duration, this);
        return hk.addHousekeeping(room);
    }
}
