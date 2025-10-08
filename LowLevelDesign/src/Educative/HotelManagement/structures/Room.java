package Educative.HotelManagement.structures;

import Educative.HotelManagement.services.RoomHousekeeping;
import Educative.HotelManagement.enums.RoomStatus;
import Educative.HotelManagement.enums.RoomStyle;

import java.util.ArrayList;
import java.util.List;

public class Room {
    private String roomNumber;
    private RoomStyle style;
    private RoomStatus status;
    private double bookingPrice;
    private boolean isSmoking;
    private List<RoomKey> keys = new ArrayList<>();
    private List<RoomHousekeeping> housekeepingLog = new ArrayList<>();

    public Room(String number, RoomStyle style, double price, boolean smoking) {
        this.roomNumber = number;
        this.style = style;
        this.bookingPrice = price;
        this.isSmoking = smoking;
        this.status = RoomStatus.AVAILABLE;
    }
    public boolean isRoomAvailable() {
        return status == RoomStatus.AVAILABLE;
    }
    public boolean checkin() {
        if (status == RoomStatus.RESERVED) {
            status = RoomStatus.OCCUPIED;
            return true;
        }
        return false;
    }
    public boolean checkout() {
        if (status == RoomStatus.OCCUPIED) {
            status = RoomStatus.AVAILABLE;
            return true;
        }
        return false;
    }

    public void addKey(RoomKey key) {
        keys.add(key);
    }

    public void addHousekeeping(RoomHousekeeping hk) {
        housekeepingLog.add(hk);
    }

    public void setStatus(RoomStatus status) {
        this.status = status;
    }
    public RoomStatus getStatus() {
        return status;
    }
    public String getRoomNumber() {
        return roomNumber;
    }
    public RoomStyle getStyle() {
        return style;
    }
    public double getBookingPrice() {
        return bookingPrice;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public void setStyle(RoomStyle style) {
        this.style = style;
    }

    public void setBookingPrice(double bookingPrice) {
        this.bookingPrice = bookingPrice;
    }

    public boolean isSmoking() {
        return isSmoking;
    }

    public void setSmoking(boolean smoking) {
        isSmoking = smoking;
    }

    public List<RoomKey> getKeys() {
        return keys;
    }

    public void setKeys(List<RoomKey> keys) {
        this.keys = keys;
    }

    public List<RoomHousekeeping> getHousekeepingLog() {
        return housekeepingLog;
    }

    public void setHousekeepingLog(List<RoomHousekeeping> housekeepingLog) {
        this.housekeepingLog = housekeepingLog;
    }


}
