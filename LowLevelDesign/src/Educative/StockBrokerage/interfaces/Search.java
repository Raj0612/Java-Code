package Educative.StockBrokerage.interfaces;

import Educative.StockBrokerage.stocks.Stock;

//Implemented in StockInventory
public interface Search {
    Stock searchSymbol(String symbol);
}
