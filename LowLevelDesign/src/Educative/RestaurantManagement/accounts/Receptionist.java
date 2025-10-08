package Educative.RestaurantManagement.accounts;

import Educative.RestaurantManagement.enums.ReservationStatus;
import Educative.RestaurantManagement.reservation.Reservation;
import Educative.RestaurantManagement.notifications.*;
import Educative.RestaurantManagement.tables.Table;

import java.time.LocalDate;

public class Receptionist extends Employee {

    public Receptionist(String name, String email, String phone, int employeeID, LocalDate dateJoined, Account account) {
        super(name, email, phone, employeeID, dateJoined, account);
    }

    public boolean createReservation(Reservation reservation) {
        // Logic to create reservation

        if (reservation == null || reservation.getCustomer() == null || reservation.getTables() == null) {
            return false;
        }

        for (Table table : reservation.getTables()) {
            if (table == null || !table.isTableFree()) {
                return false;
            }
        }

        for (Table table : reservation.getTables()) {
            table.addReservation(reservation);
        }

        reservation.setStatus(ReservationStatus.Confirmed);
        Notification notification = new SmsNotification(1, "Your reservation is confirmed for " + reservation.getTimeOfReservation(), "123456789");
        notification.send(reservation.getCustomer());
        reservation.addNotification(notification);
        return true;
    }
}
