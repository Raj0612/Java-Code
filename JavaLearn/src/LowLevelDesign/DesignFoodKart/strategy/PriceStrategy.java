package LowLevelDesign.DesignFoodKart.strategy;

import  LowLevelDesign.DesignFoodKart.Util.FoodKartUtil;
import  LowLevelDesign.DesignFoodKart.model.Restaurant;
import  LowLevelDesign.DesignFoodKart.model.User;

import java.util.*;

public class PriceStrategy implements RestaurantDisplayStrategy {
    @Override
    public List<Restaurant> findRestaurants(List<Restaurant> listOfRestaurants, User currentUser) {
        List<Restaurant> list = FoodKartUtil.getMatchingRestaurant(listOfRestaurants, currentUser);
        Collections.sort(list, new Comparator<Restaurant>() {
            @Override
            public int compare(Restaurant restaurant1, Restaurant restaurant2) {
                return Double.compare(restaurant2.getFoodItem().getPrice(), restaurant1.getFoodItem().getPrice());
            }
        });

        return list;
    }
}
