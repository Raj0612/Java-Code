package Educative.StockBrokerage.commands;

import Educative.StockBrokerage.interfaces.TradeCommand;

import java.util.*;

// Invoker: Broker
public class Broker {
    private Queue<TradeCommand> orderQueue = new LinkedList<>();

    public void takeOrder(TradeCommand command) {
        orderQueue.add(command);
    }

    public void placeOrders() {
        while (!orderQueue.isEmpty()) {
            TradeCommand cmd = orderQueue.poll();
            cmd.execute();
        }
    }
}
