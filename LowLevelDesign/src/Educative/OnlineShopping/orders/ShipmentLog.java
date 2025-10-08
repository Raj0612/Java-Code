package Educative.OnlineShopping.orders;

import Educative.OnlineShopping.enums.ShipmentStatus;

import java.time.LocalDate;

public class ShipmentLog {
    private String shipmentNumber;
    private LocalDate creationDate;
    private ShipmentStatus status;

    public ShipmentLog(String shipmentNumber, ShipmentStatus status) {
        this.shipmentNumber = shipmentNumber;
        this.status = status;
        this.creationDate = LocalDate.now();
    }

    public String getShipmentNumber() { return shipmentNumber; }
    public LocalDate getCreationDate() { return creationDate; }
    public ShipmentStatus getStatus() { return status; }
}
