package LowLevelDesign.DesignFoodKart.strategy;

import  LowLevelDesign.DesignFoodKart.model.Restaurant;
import  LowLevelDesign.DesignFoodKart.model.User;

import java.util.List;

public interface RestaurantDisplayStrategy {
    public List<Restaurant> findRestaurants(List<Restaurant> listOfRestaurants, User currentUser);
}
