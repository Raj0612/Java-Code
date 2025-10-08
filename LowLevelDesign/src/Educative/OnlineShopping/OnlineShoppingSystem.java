package Educative.OnlineShopping;

import Educative.OnlineShopping.accounts.*;
import Educative.OnlineShopping.carts.*;
import Educative.OnlineShopping.enums.*;
import Educative.OnlineShopping.notifications.*;
import Educative.OnlineShopping.orders.*;
import Educative.OnlineShopping.payments.*;
import Educative.OnlineShopping.products.*;
import Educative.OnlineShopping.search.*;

import java.time.LocalDate;
import java.util.List;

public class OnlineShoppingSystem {
    public static void main(String[] args) {
        // Create an Address instance
        Address address1 = new Address(12345, "123 Main St", "Cityville", "Stateville", "USA");

        // Create Account objects for admin and a regular user
        Account adminAcc = new Account("adminUser", "adminPass", "AliceAdmin", "admin@example.com", "1234567890");
        Account userAcc = new Account("userUser", "userPass", "BobUser", "user@example.com", "0987654321");

        // Create an Admin
        Admin admin = new Admin(adminAcc);

        // Create product categories
        ProductCategory electronics = new ProductCategory("Electronics", "Electronic items");
        ProductCategory books = new ProductCategory("Books", "A variety of books");

        // Admin adds product categories
        admin.addNewProductCategory(electronics);
        admin.addNewProductCategory(books);

        // Create a Catalog and add products
        Catalog catalog = new Catalog();
        Product product1 = new Product("P1001", "Smartphone", "Latest smartphone model", 699.99, electronics, 50, adminAcc);
        Product product2 = new Product("P2001", "Laptop", "High performance laptop", 1299.99, electronics, 30, adminAcc);
        Product product3 = new Product("P3001", "Fiction Book", "A thrilling fiction novel", 19.99, books, 100, adminAcc);

     //electronics.addProduct(product1);
      //electronics.addProduct(product2);

        catalog.addProduct(product1);
        catalog.addProduct(product2);
        catalog.addProduct(product3);

        // Create a Guest and simulate registration
        Guest guest = new Guest();
        guest.registerAccount();

        // Create an AuthenticatedUser
        AuthenticatedUser authUser = new AuthenticatedUser(userAcc);

        // Authenticated user adds items to their shopping cart
        ShoppingCart userCart = authUser.getShoppingCart();
        CartItem item1 = new CartItem(product1, 2);
        CartItem item2 = new CartItem(product3, 5);
        userCart.addItem(item1);
        userCart.addItem(item2);

        // Checkout the shopping cart
        userCart.checkout();

        // Place an order for the items in the shopping cart
        Order order = new Order("O1234", userCart);
        authUser.placeOrder(order);

        // Simulate making a payment using a CreditCard
        Payment payment = new CreditCard(userCart.getTotalPrice(), "BobUser", "4111111111111111", address1.toString(), 123);
        order.makePayment(payment);

        // Send the order for shipment
        order.sendForShipment();

        // Add an order log entry
        OrderLog orderLog = new OrderLog(order.getOrderNumber(), order.getStatus());
        order.addOrderLog(orderLog);

        // Create a shipment record (estimated arrival 3 days later)
        //Date eta = new Date(System.currentTimeMillis() + 3 * 24 * 60 * 60 * 1000L);
        LocalDate eta = LocalDate.now().plusDays(3);
        Shipment shipment = new Shipment("S5678", "Air", eta, order);
        ShipmentLog shipmentLog = new ShipmentLog(shipment.getShipmentNumber(), ShipmentStatus.PENDING);
        shipment.addShipmentLog(shipmentLog);

        // Send a notification (via Email) regarding the order status
        Notification notification = new EmailNotification(1, "Your order " + order.getOrderNumber() + " is confirmed and will be shipped soon.");
        notification.sendNotification(userAcc);

        // Demonstrate the search functionality using the Catalog
        List<Product> searchResults = catalog.searchProductsByName("laptop");
        System.out.println("Search results for 'laptop':");
        for (Product p : searchResults) {
            System.out.println(p.getName() + " - $" + p.getPrice());
        }

        // Finally, Admin blocks the user account (simulate abusive behavior)
        admin.blockUser(userAcc);
    }
}
