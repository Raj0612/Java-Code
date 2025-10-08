package Educative.RestaurantManagement.tables;
import Educative.RestaurantManagement.enums.TableStatus;
import Educative.RestaurantManagement.reservation.Reservation;

import java.time.LocalDate;
import java.util.*;
public class Table {

    private int tableID;
    private TableStatus status;
    private int maxCapacity;
    private int locationIdentifier;
    private List<TableSeat> seats = new ArrayList<>();
    private List<Reservation> reservations;

    public Table(int tableID, int maxCapacity, int locationIdentifier) {
        this.tableID = tableID;
        this.status = TableStatus.Free;
        this.maxCapacity = maxCapacity;
        this.locationIdentifier = locationIdentifier;
        this.reservations = new ArrayList<>();
    }

    public boolean isTableFree() {
        return status == TableStatus.Free;
    }

    public boolean addReservation(Reservation reservation) {
        if (isTableFree()) {
            reservations.add(reservation);
            status = TableStatus.Reserved;
            return true;
        }
        return false;
    }

    public static List<Table> search(List<Table> tables, int capacity, LocalDate startTime) {
        List<Table> available = new ArrayList<>();
        for (Table t : tables) {
            if (t.isTableFree() && t.maxCapacity >= capacity) {
                available.add(t);
            }
        }
        return available;
    }

    public int getTableID() {
        return tableID;
    }

    public void setTableID(int tableID) {
        this.tableID = tableID;
    }

    public TableStatus getStatus() {
        return status;
    }

    public void setStatus(TableStatus status) {
        this.status = status;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public int getLocationIdentifier() {
        return locationIdentifier;
    }

    public void setLocationIdentifier(int locationIdentifier) {
        this.locationIdentifier = locationIdentifier;
    }

    public List<TableSeat> getSeats() {
        return seats;
    }

    public void setSeats(List<TableSeat> seats) {
        this.seats = seats;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }
}
