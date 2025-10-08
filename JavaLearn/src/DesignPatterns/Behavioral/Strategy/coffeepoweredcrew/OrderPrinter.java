package DesignPatterns.Behavioral.Strategy.coffeepoweredcrew;

import java.util.Collection;

//Strategy
public interface OrderPrinter {
	
	void print(Collection<Order> orders);
}
