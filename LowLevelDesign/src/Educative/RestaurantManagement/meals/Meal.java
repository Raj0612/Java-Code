package Educative.RestaurantManagement.meals;

import java.util.*;

import Educative.RestaurantManagement.menus.MenuItem;
import Educative.RestaurantManagement.tables.TableSeat;

public class Meal {

    private int mealID;
    private TableSeat seat;
    private List<MealItem> mealItems;

    public Meal(int mealID, TableSeat seat) {
        this.mealID = mealID;
        this.seat = seat;
        this. mealItems = new ArrayList<>();
    }

    public boolean addMealItem(MealItem mealItem) {
        mealItems.add(mealItem);
        return true;
    }
}
