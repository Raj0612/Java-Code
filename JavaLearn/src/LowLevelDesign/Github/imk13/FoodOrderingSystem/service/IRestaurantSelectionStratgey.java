package LowLevelDesign.Github.imk13.FoodOrderingSystem.service;


import LowLevelDesign.Github.imk13.FoodOrderingSystem.restaurant.Restaurant;
import LowLevelDesign.Github.imk13.FoodOrderingSystem.system.RestaurantManager;

import java.util.HashMap;

public interface IRestaurantSelectionStratgey {
    public Restaurant findBy(HashMap<String, Integer> orderedItems);
}
