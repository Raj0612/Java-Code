package Educative.StockBrokerage.stocks;

import java.util.*;

public class StockPosition {
    private String symbol;
    private double quantity;
    private List<StockLot> lots;

    public StockPosition(String symbol, double quantity) {
        this.symbol = symbol;
        this.quantity = quantity;
        this.lots = new ArrayList<>();
    }
    public String getSymbol() { return symbol; }
    public double getQuantity() { return quantity; }
    public void addLot(StockLot lot) { lots.add(lot); }
}
