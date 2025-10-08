package Educative.StockBrokerage.stocks;

import Educative.StockBrokerage.orders.Order;

public class StockLot {
    private String lotNumber;
    private Order buyingOrder;
    private double buyingPrice;

    public StockLot(String lotNumber, Order buyingOrder, double buyingPrice) {
        this.lotNumber = lotNumber;
        this.buyingOrder = buyingOrder;
        this.buyingPrice = buyingPrice;
    }
    public double getBuyingPrice() { return buyingPrice; }
}
