package Educative.StockBrokerage.stocks;

import Educative.StockBrokerage.interfaces.Search;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class StockInventory implements Search {
    private static class Helper {
        private static final StockInventory INSTANCE = new StockInventory();
    }
    private Map<String, Stock> stockMap;
    private StockInventory() {
        stockMap = new ConcurrentHashMap<>();
    }
    public static StockInventory getInstance() {
        return Helper.INSTANCE;
    }
    public void addStock(Stock stock) {
        stockMap.put(stock.getSymbol(), stock);
    }
    @Override
    public Stock searchSymbol(String symbol) {
        return stockMap.get(symbol);
    }
    public void updateStockPrice(String symbol, double price) {
        Stock stock = stockMap.get(symbol);
        if (stock != null) stock.setPrice(price);
    }
}
