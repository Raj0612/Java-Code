package Educative.StockBrokerage.orders;
import Educative.StockBrokerage.accounts.Member;
import Educative.StockBrokerage.enums.TimeEnforcementType;
import Educative.StockBrokerage.stocks.Stock;
public class MarketOrder extends Order {
    public MarketOrder(Member member, Stock stock, double quantity, TimeEnforcementType timeEnforcement, boolean isBuyOrder) {
        super(member, stock, quantity, 0, timeEnforcement, isBuyOrder);
    }
}

