package Educative.StockBrokerage.interfaces;

import Educative.StockBrokerage.stocks.Stock;

//Implemented in Member
public interface StockObserver {
    void update(Stock stock);
}
