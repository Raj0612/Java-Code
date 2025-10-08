package Educative.RestaurantManagement.tables;

import Educative.RestaurantManagement.enums.SeatType;

public class TableSeat {

    private int tableSeatNumber;
    private SeatType type;

    public TableSeat(int tableSeatNumber, SeatType type) {
        this.tableSeatNumber = tableSeatNumber;
        this.type = type;
    }

    public boolean updateSeatType(SeatType type) {
        this.type = type;
        return true;
    }

    public int getTableSeatNumber() {
        return tableSeatNumber;
    }

    public void setTableSeatNumber(int tableSeatNumber) {
        this.tableSeatNumber = tableSeatNumber;
    }

    public SeatType getType() {
        return type;
    }

    public void setType(SeatType type) {
        this.type = type;
    }
}
