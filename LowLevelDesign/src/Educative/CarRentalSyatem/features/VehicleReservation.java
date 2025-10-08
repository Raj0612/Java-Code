package Educative.CarRentalSyatem.features;

import Educative.CarRentalSyatem.enums.ReservationStatus;
import Educative.CarRentalSyatem.equipment.Equipment;
import Educative.CarRentalSyatem.service.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class VehicleReservation {
    private int reservationId;
    private String customerId;
    private String vehicleId;
    private LocalDateTime creationDate;
    private ReservationStatus status;
    private LocalDate dueDate;
    private LocalDate returnDate;
    private String pickupLocation;
    private String returnLocation;
    private List<Equipment> equipments = new ArrayList<>();
    private List<Service> services = new ArrayList<>();

    public VehicleReservation() {
    }

    public VehicleReservation(int reservationId, String customerId, String vehicleId,
                              LocalDateTime creationDate, ReservationStatus status,
                              LocalDate dueDate, LocalDate returnDate,
                              String pickupLocation, String returnLocation) {
        this.reservationId = reservationId;
        this.customerId = customerId;
        this.vehicleId = vehicleId;
        this.creationDate = creationDate;
        this.status = status;
        this.dueDate = dueDate;
        this.returnDate = returnDate;
        this.pickupLocation = pickupLocation;
        this.returnLocation = returnLocation;
    }



    public int getReservationId() {
        return reservationId;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public ReservationStatus getStatus() {
        return status;
    }

    public void setStatus(ReservationStatus status) {
        this.status = status;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public String getPickupLocation() {
        return pickupLocation;
    }

    public void setPickupLocation(String pickupLocation) {
        this.pickupLocation = pickupLocation;
    }

    public String getReturnLocation() {
        return returnLocation;
    }

    public void setReturnLocation(String returnLocation) {
        this.returnLocation = returnLocation;
    }

    public List<Equipment> getEquipments() {
        return equipments;
    }

    public List<Service> getServices() {
        return services;
    }

    public void addEquipment(Equipment equipment) {
        equipments.add(equipment);
    }

    public void addService(Service service) {
        services.add(service);
    }
}
