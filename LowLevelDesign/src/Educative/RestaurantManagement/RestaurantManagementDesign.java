package Educative.RestaurantManagement;

import Educative.RestaurantManagement.accounts.*;
import Educative.RestaurantManagement.commad.PlaceOrderCommand;
import Educative.RestaurantManagement.commad.ProcessPaymentCommand;
import Educative.RestaurantManagement.enums.OrderStatus;
import Educative.RestaurantManagement.enums.PaymentStatus;
import Educative.RestaurantManagement.enums.ReservationStatus;
import Educative.RestaurantManagement.enums.SeatType;
import Educative.RestaurantManagement.meals.Kitchen;
import Educative.RestaurantManagement.meals.Meal;
import Educative.RestaurantManagement.meals.MealItem;
import Educative.RestaurantManagement.meals.Order;
import Educative.RestaurantManagement.menus.Menu;
import Educative.RestaurantManagement.menus.MenuItem;
import Educative.RestaurantManagement.menus.MenuSection;
import Educative.RestaurantManagement.notifications.Notification;
import Educative.RestaurantManagement.notifications.SmsNotification;
import Educative.RestaurantManagement.payments.Bill;
import Educative.RestaurantManagement.payments.Payment;
import Educative.RestaurantManagement.payments.PaymentFactory;
import Educative.RestaurantManagement.payments.strategy.NewYearDiscount;
import Educative.RestaurantManagement.reservation.Reservation;
import Educative.RestaurantManagement.restaurants.Branch;
import Educative.RestaurantManagement.restaurants.Restaurant;
import Educative.RestaurantManagement.tables.Table;
import Educative.RestaurantManagement.tables.TableSeat;

import java.time.LocalDate;
import java.util.List;

public class RestaurantManagementDesign {

    public static void main(String[] args) {
        Restaurant restaurant = Restaurant.getInstance();
        // Setup branches, menus, tables, etc.

        // 2. Set up Menu
        Menu menu = new Menu(1, "Main Menu", "Description", 10.99);
        MenuSection appetizers = new MenuSection(1, "Appetizers", "Description");
        MenuItem item1 = new MenuItem(1, "Spring Rolls", "Delicious spring rolls", 5.99);
        appetizers.addMenuItem(item1);
        menu.addMenuSection(appetizers);

        // 3. Add Employees
        Waiter waiter = new Waiter("Alice", "2gBm3@example.com", "123-456-7890", 1, LocalDate.now(), null);
        Chef chef = new Chef("Bob", "2gBm3@example.com", "123-456-7890", 1, LocalDate.now(), null);
        Receptionist receptionist = new Receptionist( "Clara", "2gBm3@example.com", "123-456-7890", 1, LocalDate.now(), null);
        Manager manager = new Manager("Dana", "2gBm3@example.com", "123-456-7890", 1, LocalDate.now(), null);

        //4. Create Branch
        Address branchAddress = new Address(123, "123 Main St", "New York", "NY", "USA");
        Kitchen kitchen = new Kitchen("Kitchen 1");
        Branch branch = new Branch("Downtown",branchAddress,kitchen, menu);

        restaurant.addBranch(branch);

        branch.addEmployee(waiter);
        branch.addEmployee(chef);
        branch.addEmployee(receptionist);
        branch.addEmployee(manager);

        // 5. Create Tables and Seats
        Table table = new Table(101, 4, 1);
        TableSeat seat1 = new TableSeat(1, SeatType.Regular);
        TableSeat seat2 = new TableSeat(2, SeatType.Regular);
        table.getSeats().add(seat1);
        table.getSeats().add(seat2);
        branch.getTables().add(table);

        // 6. Make Reservation
        Customer customer = new Customer("Eve", "2gBm3@example.com", "123-456-7890", LocalDate.now());
        Reservation reservation = new Reservation(1, LocalDate.now(), 3, ReservationStatus.Requested, "Notes", LocalDate.now().plusDays(1), customer);
        reservation.getTables().add(table);
        reservation.addObserver((res, msg) -> System.out.println("Notification for reservation: " + msg));
        table.addReservation(reservation);

        // 7. Search for available tables
        List<Table> availableTables = Table.search(branch.getTables(), 2, LocalDate.now());
        System.out.println("Available tables: " + availableTables.size());

        // 8. Place an Order (Command Pattern)
        Meal mealForSeat1 = new Meal(1, seat1);
        MealItem mealItem1 = new MealItem(1, 2, item1);
        mealForSeat1.addMealItem(mealItem1);

        Order order = new Order(1, OrderStatus.Preparing, LocalDate.now(), table, waiter, chef);
        order.addMeal(seat1, mealForSeat1);

        PlaceOrderCommand placeOrderCommand = new PlaceOrderCommand(order);
        placeOrderCommand.execute();

        // 9. Process Payment (Factory + Strategy)
        Payment payment = PaymentFactory.createPayment(
                "CreditCard",
                1,
                11.98,
                PaymentStatus.Pending,
                new NewYearDiscount()
        );
        payment.applyDiscount();
        ProcessPaymentCommand processPaymentCommand = new ProcessPaymentCommand(payment);
        processPaymentCommand.execute();

        // 10. Print Bill
        Bill bill = new Bill(1, (float) payment.getAmount(),(float) 5.0, 1.0f, true);
        bill.generateBill();

        // 11. Send Notification (Observer)
        Notification notification = new SmsNotification(1, "Your order is ready", "123456789");
        notification.send(customer);

        // 12. Remove Employee
        branch.removeEmployee(waiter);

        // 13. Print out summary
        System.out.println("Branch employees after removal: " + branch.getEmployees().size());
        System.out.println("Order status: " + order.getStatus());
        System.out.println("Payment status: " + payment.getStatus());
        System.out.println("Reservation status: " + reservation.getStatus());
    }
}
