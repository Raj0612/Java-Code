package DesignPatterns.Behavioral.Observer.medianStock;

public interface StockObserver {
    void update(String stockSymbol, double stockPrice);
}
