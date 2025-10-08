package LowLevelDesign.Github.imk13.FoodOrderingSystem.payments;


import LowLevelDesign.Github.imk13.FoodOrderingSystem.order.Order;

// TBD
public class AbstractPayment {
    IPaymentStrategy paymentStrategy;
    Order order;

    public void doPayment(Order order) {
        paymentStrategy.pay(order);
    }
}
