import DesignPatterns.Behavioral.Observer.medianStock.Investor;
import DesignPatterns.Behavioral.Observer.medianStock.StockMarket;
import DesignPatterns.Behavioral.Observer.medianStock.StockMarketImpl;
import DesignPatterns.Behavioral.Observer.medianStock.StockObserver;

public class Client {

    public static void main(String[] args) {
        //StockMarket stockMarket = new StockMarketImpl();
        StockMarketImpl stockMarket = new StockMarketImpl();
        StockObserver investor1 = new Investor("Alice");
        StockObserver investor2 = new Investor("Bob");

        stockMarket.registerObserver(investor1);
        stockMarket.registerObserver(investor2);

        stockMarket.setStockPrice("INFY", 1250.0); // Both investors receive updates
        stockMarket.setStockPrice("TCS", 2500.0); // Both investors receive updates

        stockMarket.removeObserver(investor1);

        stockMarket.setStockPrice("WIPRO", 700.0);
    }

}
