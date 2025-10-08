package Educative.ParkingLot.features;

import Educative.ParkingLot.enums.TicketStatus;
import Educative.ParkingLot.parkingspots.ParkingSpot;
import Educative.ParkingLot.payments.Payment;
import Educative.ParkingLot.vehicles.Vehicle;

import java.time.LocalDateTime;

public class ParkingTicket {
    private int ticketNo;
    private LocalDateTime entryTime;
    private LocalDateTime exitTime;
    private double amount;
    private TicketStatus status;
    private Vehicle vehicle;
    private Payment payment;
    private Entrance entrance;
    private Exit exitIns;
    private ParkingSpot parkingSpot;

    public ParkingTicket(int ticketNo, LocalDateTime entryTime, Vehicle vehicle, Entrance entrance) {
        this.ticketNo = ticketNo;
        this.entryTime = entryTime;
        this.vehicle = vehicle;
        this.entrance = entrance;
        this.status = TicketStatus.ISSUED;
        this.amount = 0.0;
        this.exitTime = null;
        this.payment = null;
        this.exitIns = null;
        this.parkingSpot = null;
    }

    public int getTicketNo() {
        return ticketNo;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public LocalDateTime getExitTime() {
        return exitTime;
    }

    public void setExitTime(LocalDateTime exitTime) {
        this.exitTime = exitTime;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public TicketStatus getStatus() {
        return status;
    }

    public void setStatus(TicketStatus status) {
        this.status = status;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Entrance getEntrance() {
        return entrance;
    }

    public Exit getExitIns() {
        return exitIns;
    }

    public void setExitIns(Exit exitIns) {
        this.exitIns = exitIns;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    public void setParkingSpot(ParkingSpot parkingSpot) {
        this.parkingSpot = parkingSpot;
    }
}
