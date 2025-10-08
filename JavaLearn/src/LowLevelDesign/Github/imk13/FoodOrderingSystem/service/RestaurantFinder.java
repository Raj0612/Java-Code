package LowLevelDesign.Github.imk13.FoodOrderingSystem.service;


import LowLevelDesign.Github.imk13.FoodOrderingSystem.exceptions.BonVivantException;
import LowLevelDesign.Github.imk13.FoodOrderingSystem.restaurant.Restaurant;

import java.util.HashMap;


public class RestaurantFinder {
    private IRestaurantSelectionStratgey _restaurantSelectionStratgey;
    
    public RestaurantFinder(){
    }

    public RestaurantFinder useStrategy(IRestaurantSelectionStratgey stratgey){
        _restaurantSelectionStratgey = stratgey;
        return this;
    }

    public Restaurant findRestaurant(HashMap<String, Integer> orderedItems)
        throws BonVivantException {
        if(_restaurantSelectionStratgey == null){
            throw new BonVivantException("IRestaurantSelectionStratgey strategy is not set.");
        }
        return _restaurantSelectionStratgey.findBy(orderedItems);
    }
}
