package LowLevelDesign.Github.imk13.FoodOrderingSystem.payments;


import LowLevelDesign.Github.imk13.FoodOrderingSystem.order.Order;

public interface IPaymentStrategy {
    void pay(Order order);
}
