package Educative.StockBrokerage;

import Educative.StockBrokerage.accounts.*;
import Educative.StockBrokerage.commands.*;
import Educative.StockBrokerage.enums.*;
import Educative.StockBrokerage.interfaces.*;
import Educative.StockBrokerage.stockexchange.StockExchange;
import Educative.StockBrokerage.stocks.*;

public class StockBrokerageDemo {
    public static void main(String[] args) {
        // 1. Create Address, Members, and Admin
        Address addr1 = new Address(10001, "123 Wall Street", "New York", "NY", "USA");
        Address addr2 = new Address(20001, "456 Silicon Ave", "San Francisco", "CA", "USA");
        Member alice = new Member("alice01", "pass123", "Alice", addr1, "alice@email.com", "1111111111", 10000);
        Member bob = new Member("bob02", "pass456", "Bob", addr2, "bob@email.com", "2222222222", 5000);
        Admin admin = new Admin("admin01", "adminpass", "SuperAdmin", addr1, "admin@email.com", "9999999999");

        // 2. Add stocks to StockInventory (Singleton)
        StockInventory inventory = StockInventory.getInstance();
        Stock apple = new Stock("AAPL", 180.0, "Apple Inc.");
        Stock tesla = new Stock("TSLA", 900.0, "Tesla Inc.");
        inventory.addStock(apple);
        inventory.addStock(tesla);

        // 3. Members create watchlists and add stocks
        Watchlist aliceWatchlist = new Watchlist("Tech Giants");
        aliceWatchlist.addStock(apple);
        aliceWatchlist.addStock(tesla);
        alice.getWatchlists().add(aliceWatchlist);

        // 4. Members place buy and sell orders using Command Pattern
        Broker broker = new Broker();

        // Alice places a buy limit order for Apple
        TradeCommand aliceBuyApple = new BuyStockCommand(
                alice, apple, 20, 175.0, TimeEnforcementType.GOOD_TILL_CANCELED);
        broker.takeOrder(aliceBuyApple);

        // Bob places a sell limit order for Tesla (simulate he already owns TSLA)
        bob.getStockPositions().put(tesla.getName(), new StockPosition(tesla.getSymbol(), 10));
        TradeCommand bobSellTesla = new SellStockCommand(
                bob, tesla, 5, 910.0, TimeEnforcementType.GOOD_TILL_CANCELED);
        broker.takeOrder(bobSellTesla);

        // 5. Place all queued orders
        broker.placeOrders();

        // 6. Simulate a price drop for Apple to trigger Alice's buy limit order (Observer Pattern)
        System.out.println("\n--- Stock price update: Apple drops to $174 ---");
        inventory.updateStockPrice("AAPL", 174.0);
        StockExchange.getInstance().notifyObservers("AAPL");

        // 7. Simulate a price rise for Tesla to trigger Bob's sell limit order
        System.out.println("\n--- Stock price update: Tesla rises to $915 ---");
        inventory.updateStockPrice("TSLA", 915.0);
        StockExchange.getInstance().notifyObservers("TSLA");

        // 8. Admin blocks Alice
        System.out.println("\n--- Admin blocks Alice ---");
        admin.blockMember(alice);
        System.out.println("Alice status: " + alice.getStatus());

        // 9. Admin unblocks Alice
        System.out.println("\n--- Admin unblocks Alice ---");
        admin.unblockMember(alice);
        System.out.println("Alice status: " + alice.getStatus());

        // 10. Notifications are sent upon order execution (see EmailNotification output)
        System.out.println("\nDemo completed.");
    }
}
