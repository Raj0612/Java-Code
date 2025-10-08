package Educative.HotelManagement.services;

import Educative.HotelManagement.accounts.Housekeeper;
import Educative.HotelManagement.structures.Room;

import java.time.LocalDateTime;

public class RoomHousekeeping {
    private String description;
    private LocalDateTime startDatetime;
    private int duration;
    private Housekeeper housekeeper;

    public RoomHousekeeping(String desc, LocalDateTime start, int duration, Housekeeper hk) {
        this.description = desc;
        this.startDatetime = start;
        this.duration = duration;
        this.housekeeper = hk;
    }
    public boolean addHousekeeping(Room room) {
        room.addHousekeeping(this);
        return true;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getStartDatetime() {
        return startDatetime;
    }

    public void setStartDatetime(LocalDateTime startDatetime) {
        this.startDatetime = startDatetime;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Housekeeper getHousekeeper() {
        return housekeeper;
    }

    public void setHousekeeper(Housekeeper housekeeper) {
        this.housekeeper = housekeeper;
    }
}
