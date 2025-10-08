package Educative.StockBrokerage.stocks;

public class Stock {
    private String symbol;
    private double price;
    private String name;

    public Stock(String symbol, double price, String name) {
        this.symbol = symbol;
        this.price = price;
        this.name = name;
    }

    public String getSymbol() { return symbol; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
    public String getName() { return name; }
}
