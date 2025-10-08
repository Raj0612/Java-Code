package LowLevelDesign.DesignFoodKart.dao;


import LowLevelDesign.DesignFoodKart.model.Order;

import java.util.HashMap;

public class OrderDao {
    HashMap<Integer, Order> listOfOrders;
    HashMap<String, Order> userOrderMap;
}
