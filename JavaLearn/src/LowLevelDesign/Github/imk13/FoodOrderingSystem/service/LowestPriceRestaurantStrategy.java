package LowLevelDesign.Github.imk13.FoodOrderingSystem.service;

import LowLevelDesign.Github.imk13.FoodOrderingSystem.enums.ItemStatus;
import LowLevelDesign.Github.imk13.FoodOrderingSystem.restaurant.FoodItem;
import LowLevelDesign.Github.imk13.FoodOrderingSystem.restaurant.Restaurant;
import LowLevelDesign.Github.imk13.FoodOrderingSystem.system.RestaurantManager;

import java.util.ArrayList;
import java.util.HashMap;


public class LowestPriceRestaurantStrategy implements IRestaurantSelectionStratgey {

    @Override
    public Restaurant findBy(HashMap<String, Integer> orderedItems) {
        ArrayList<Restaurant> restaurants= RestaurantManager.getInstance().getAvailableRestaurants();
        Restaurant orderFromRestaurant = null;
        Double minPrice = Double.MAX_VALUE;
        for(Restaurant restaurant: restaurants) {
            Boolean hasFoundAll = true;
            Double restaurantPrice = 0.0;
            for(String itemName: orderedItems.keySet()){
                FoodItem orderItem = restaurant.getMenu().findFoodItem(itemName);
                if(orderItem == null){
                    hasFoundAll = false;
                    break;
                }else if(orderItem.getStatus() != ItemStatus.AVAILABLE){
                    hasFoundAll = false;
                    break;
                }
                restaurantPrice += orderItem.getPrice() * orderedItems.get(orderItem.getName());
            }
            if(hasFoundAll && restaurantPrice < minPrice){
                minPrice = restaurantPrice;
                orderFromRestaurant = restaurant;
            }
        }
        return orderFromRestaurant;
    }
}
