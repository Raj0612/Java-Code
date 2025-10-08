package Educative.RestaurantManagement.meals;

import java.time.LocalDate;
import java.util.*;
import Educative.RestaurantManagement.enums.OrderStatus;
import Educative.RestaurantManagement.accounts.*;
import Educative.RestaurantManagement.tables.Table;
import Educative.RestaurantManagement.tables.TableSeat;

public class Order {
    private int orderID;
    private OrderStatus status;
    private LocalDate creationTime;
    private Map<TableSeat, Meal> seatMealMap;
    private Table table;
    private Waiter waiter;
    private Chef chef;


    public Order(int orderID, OrderStatus status, LocalDate creationTime, Table table, Waiter waiter, Chef chef) {
        this.orderID = orderID;
        this.status = status;
        this.creationTime = creationTime;
        this.table = table;
        this.waiter = waiter;
        this.chef = chef;
        this.seatMealMap = new HashMap<>();
    }

    public boolean addMeal(TableSeat seat, Meal meal) {
        seatMealMap.put(seat, meal);
        return true;
    }

    public boolean removeMeal(TableSeat seat) {
        seatMealMap.remove(seat);
        return true;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public LocalDate getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(LocalDate creationTime) {
        this.creationTime = creationTime;
    }

    public Map<TableSeat, Meal> getSeatMealMap() {
        return seatMealMap;
    }

    public void setSeatMealMap(Map<TableSeat, Meal> seatMealMap) {
        this.seatMealMap = seatMealMap;
    }


    public Table getTable() {
        return table;
    }

    public void setTable(Table table) {
        this.table = table;
    }

    public Waiter getWaiter() {
        return waiter;
    }

    public void setWaiter(Waiter waiter) {
        this.waiter = waiter;
    }

    public Chef getChef() {
        return chef;
    }

    public void setChef(Chef chef) {
        this.chef = chef;
    }

}
