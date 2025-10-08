package Educative.CarRentalSyatem;

import Educative.CarRentalSyatem.account.*;
import Educative.CarRentalSyatem.appservice.CarRentalSystem;
import Educative.CarRentalSyatem.appservice.ReservationService;
import Educative.CarRentalSyatem.payment.CreditCardPayment;
import Educative.CarRentalSyatem.appservice.NotificationService;
import Educative.CarRentalSyatem.enums.*;
import Educative.CarRentalSyatem.equipment.*;
import Educative.CarRentalSyatem.features.*;
import Educative.CarRentalSyatem.notification.*;
import Educative.CarRentalSyatem.payment.*;
import Educative.CarRentalSyatem.search.*;
import Educative.CarRentalSyatem.service.*;
import Educative.CarRentalSyatem.vehicle.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
public class CarRentalSystemDemo {
    public static void main(String[] args) {
        System.out.println("=============================================");
        System.out.println("        CAR RENTAL SYSTEM DEMO");
        System.out.println("=============================================\n");

        // 1. Branch Setup
        System.out.println("1. Branch Setup");
        CarRentalSystem rentalSystem = CarRentalSystem.getInstance();
        CarRentalBranch branch1 = new CarRentalBranch(
                "Airport Branch",
                new Address("123 Main St", "Seattle", "WA", 98101, "USA"),
                new ArrayList<>());
        rentalSystem.addNewBranch(branch1);
        System.out.println("   -> Branch added: " + branch1.getName() + " (" + branch1.getAddress().getCity() + ")\n");

        // 2. Add Vehicles
        System.out.println("2. Adding Vehicles to Inventory");
        Vehicle car1 = new Car("C1001", "ABC123", 5, VehicleStatus.AVAILABLE, "Toyota Corolla", 2022, CarType.ECONOMY);
        Vehicle van1 = new Van("V1001", "XYZ789", 12, VehicleStatus.AVAILABLE, "Ford Transit", 2021, VanType.PASSENGER);

        VehicleCatalog catalog = new VehicleCatalog();
        catalog.addVehicle(car1);
        catalog.addVehicle(van1);

        System.out.println("   -> Vehicles added: ");
        System.out.println("      - " + car1.getModel() + " (ID: " + car1.getVehicleId() + ")");
        System.out.println("      - " + van1.getModel() + " (ID: " + van1.getVehicleId() + ")\n");

        // 3. Customer Registration
        System.out.println("3. Customer Registration & Login");
        Customer customer1 = new Customer();
        customer1.setAccountId("U123");
        customer1.setName("Alice Smith");
        customer1.setEmail("alice@email.com");
        customer1.setLicenseNumber("D1234567");
        customer1.setLicenseExpiry(LocalDate.of(2027, 2, 1));
        customer1.setStatus(AccountStatus.ACTIVE);

        System.out.println("   -> [LOGIN] Customer: " + customer1.getName() + " (ID: " + customer1.getAccountId() + ")");
        System.out.println("   -> Driver License #: " + customer1.getLicenseNumber() +
                " (Expires: " + customer1.getLicenseExpiry() + ")\n");

        // Initialize Reservation Service
        ReservationService reservationService = new ReservationService();

        // 4. Vehicle Search
        System.out.println("4. Vehicle Search");
        List<Vehicle> cars = catalog.searchByType("CAR");
        if (!cars.isEmpty()) {
            System.out.println("   -> Found " + cars.size() + " car(s) in inventory:");
            for (Vehicle v : cars) {
                System.out.println("      - Model: " + v.getModel() + ", ID: " + v.getVehicleId() + ", Status: " + v.getStatus());
            }
        } else {
            System.out.println("   -> No cars found in inventory.");
        }
        System.out.println();

        // 5. Create Reservation
        System.out.println("5. Creating Reservation");
        VehicleReservation reservation = reservationService.createReservation(
                customer1.getAccountId(),
                car1.getVehicleId(),
                "Airport Branch",
                "Airport Branch",
                LocalDate.now().plusDays(3)
        );
        System.out.println("   -> Reservation created with ID: " + reservation.getReservationId());

        // 6. Confirm Reservation and Notify
        System.out.println("6. Confirming Reservation");
        reservationService.confirmReservation(reservation, customer1);

        // 7. Add Equipment and Services
        System.out.println("7. Adding Equipment and Services");
        ChildSeat childSeat = new ChildSeat(1, 15);
        reservation.addEquipment(childSeat);

        DriverService driverServiceFeature = new DriverService(1, 50, 101);
        reservation.addService(driverServiceFeature);

        System.out.println("   -> Added Equipment: Child Seat");
        System.out.println("   -> Added Service: Driver Service\n");

        // 8. Payment Processing using Strategy Pattern
        System.out.println("8. Payment Processing");
        Payment payment = new Payment(200, new CreditCardPayment("1234567890123456", "Alice Smith", "12/25", "123"));
        payment.setTimestamp(LocalDateTime.now());
        payment.setStatus(PaymentStatus.UNPAID);
        System.out.println("   -> Processing payment of $" + payment.getAmount());
        boolean paymentSuccess = payment.makePayment();
        if (paymentSuccess) {
            System.out.println("   -> Payment successful");
        } else {
            System.out.println("   -> Payment failed");
        }
        System.out.println();

        // 9. Notify Customer about Payment
        NotificationService notificationService = new NotificationService();
        notificationService.registerObserver(new EmailNotification(customer1));
        notificationService.registerObserver(new SmsNotification(customer1));
        notificationService.notifyObservers("Your payment for reservation #" + reservation.getReservationId() + " has been processed.");

        // 10. Vehicle Pickup
        System.out.println("10. Vehicle Pickup");
        car1.reserve();
        System.out.println("   -> " + customer1.getName() + " picked up vehicle: " + car1.getModel());

        // 11. Vehicle Return
        System.out.println("11. Vehicle Return");
        car1.returnVehicle();
        reservation.setReturnDate(LocalDate.now().plusDays(3));
        reservation.setStatus(ReservationStatus.COMPLETED);
        System.out.println("   -> Vehicle returned on: " + reservation.getReturnDate());
        System.out.println("   -> Reservation status updated to COMPLETED\n");

        // 12. Check for Overdue and Impose Fine if necessary
        if (reservation.getReturnDate().isAfter(reservation.getDueDate())) {
            double fineAmount = 100.0;
            String reason = "Late return";
            Fine fine = new Fine(fineAmount, reason);
            System.out.println("   -> Overdue! Fine imposed: $" + fine.getAmount() + " for " + fine.getReason());

            // Notify customer about fine
            notificationService.notifyObservers("You have been fined $" + fineAmount + " for " + reason);
        } else {
            System.out.println("   -> Vehicle returned on time. No fine imposed.\n");
        }

        // 13. Display Reservation History
        System.out.println("13. Reservation History for Customer");
        List<VehicleReservation> history = reservationService.getReservationHistory(customer1.getAccountId());
        for (VehicleReservation res : history) {
            System.out.println("   - Reservation ID: " + res.getReservationId() + ", Status: " + res.getStatus() +
                    ", Pickup: " + res.getPickupLocation() + ", Return: " + res.getReturnDate());
        }

        System.out.println("\n=============================================");
        System.out.println("             END OF DEMO");
        System.out.println("=============================================");
    }
}
