package Educative.OnlineShopping.orders;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Shipment {
    private String shipmentNumber;
    private LocalDate shipmentDate;
    private LocalDate estimatedArrival;
    private String shipmentMethod;
    private List<ShipmentLog> shipmentLogs;

    private Order order;

    public Shipment(String shipmentNumber, String shipmentMethod, LocalDate estimatedArrival, Order order) {
        this.shipmentNumber = shipmentNumber;
        this.shipmentMethod = shipmentMethod;
        this.estimatedArrival = estimatedArrival;
        this.shipmentDate = LocalDate.now();
        this.shipmentLogs = new ArrayList<>();
        this.order = order;
    }

    public boolean addShipmentLog(ShipmentLog log) {
        shipmentLogs.add(log);
        System.out.println("Shipment log added for shipment '" + shipmentNumber + "'.");
        return true;
    }

    public String getShipmentNumber() {
        return shipmentNumber;
    }

    public void setShipmentNumber(String shipmentNumber) {
        this.shipmentNumber = shipmentNumber;
    }

    public LocalDate getShipmentDate() {
        return shipmentDate;
    }

    public void setShipmentDate(LocalDate shipmentDate) {
        this.shipmentDate = shipmentDate;
    }

    public LocalDate getEstimatedArrival() {
        return estimatedArrival;
    }

    public void setEstimatedArrival(LocalDate estimatedArrival) {
        this.estimatedArrival = estimatedArrival;
    }

    public String getShipmentMethod() {
        return shipmentMethod;
    }

    public void setShipmentMethod(String shipmentMethod) {
        this.shipmentMethod = shipmentMethod;
    }

    public List<ShipmentLog> getShipmentLogs() {
        return shipmentLogs;
    }

    public void setShipmentLogs(List<ShipmentLog> shipmentLogs) {
        this.shipmentLogs = shipmentLogs;
    }
}
