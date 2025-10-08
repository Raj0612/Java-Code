package Educative.StockBrokerage.commands;

import Educative.StockBrokerage.accounts.Member;
import Educative.StockBrokerage.enums.TimeEnforcementType;
import Educative.StockBrokerage.interfaces.TradeCommand;
import Educative.StockBrokerage.stockexchange.StockExchange;
import Educative.StockBrokerage.stocks.Stock;
public class SellStockCommand  implements TradeCommand {
    private Member member;
    private Stock stock;
    private double quantity;
    private double price;
    private TimeEnforcementType enforcementType;

    public SellStockCommand(Member member, Stock stock, double quantity, double price, TimeEnforcementType enforcementType) {
        this.member = member;
        this.stock = stock;
        this.quantity = quantity;
        this.price = price;
        this.enforcementType = enforcementType;
    }

    @Override
    public void execute() {
        StockExchange.getInstance().sellStock(member, stock, quantity, price, enforcementType);
    }
}
