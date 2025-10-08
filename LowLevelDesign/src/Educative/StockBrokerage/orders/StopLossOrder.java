package Educative.StockBrokerage.orders;
import Educative.StockBrokerage.accounts.Member;
import Educative.StockBrokerage.enums.TimeEnforcementType;
import Educative.StockBrokerage.stocks.Stock;
public class StopLossOrder extends Order {
    public StopLossOrder(Member member, Stock stock, double quantity, double limitPrice, TimeEnforcementType timeEnforcement, boolean isBuyOrder) {
        super(member, stock, quantity, limitPrice, timeEnforcement, isBuyOrder);
    }
}
