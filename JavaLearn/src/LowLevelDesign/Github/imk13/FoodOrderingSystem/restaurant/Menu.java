package LowLevelDesign.Github.imk13.FoodOrderingSystem.restaurant;

import LowLevelDesign.Github.imk13.FoodOrderingSystem.enums.MenuType;
import LowLevelDesign.Github.imk13.FoodOrderingSystem.exceptions.BonVivantException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Menu {
    private HashMap<MenuType, HashMap<String, FoodItem>> menuMap;

    public Menu(){
        resetMenu();
    }
    /**
     * @return the List of all FoodItem
     */
    public List<FoodItem> allItems() {
        ArrayList<FoodItem> allFooddItems = new ArrayList<>();
        for(MenuType menuType: MenuType.values()){
            HashMap<String, FoodItem> foodMenuMap = menuMap.get(menuType);
            allFooddItems.addAll(foodMenuMap.values());
        }
        return allFooddItems;
    }

    public void addFoodItem(FoodItem item){
        if(item.getCategory() == null){
            //throw new BonVivantException("FoodItem menu category is missing.");
            return;
        }
        if(menuMap.get(item.getCategory()) == null){
            menuMap.put(item.getCategory(), new HashMap<>());
        }
        menuMap.get(item.getCategory()).put(item.getName(), item);
    }

    public FoodItem findFoodItem(String itemName){
        for(MenuType menuType: MenuType.values()){
            HashMap<String, FoodItem> foodMenuMap = menuMap.get(menuType);
            if(foodMenuMap != null && foodMenuMap.containsKey(itemName)){
                return foodMenuMap.get(itemName);
            }
        }
        return null;
    }

    public FoodItem findFoodItem(FoodItem foodItem){
        HashMap<String, FoodItem> foodMenuMap = menuMap.get(foodItem.getCategory());
        if(foodMenuMap.containsKey(foodItem.getName())){
            return foodMenuMap.get(foodItem.getName());
        }
        return null;
    }

    public FoodItem updateFoodItem(FoodItem foodItem){
        HashMap<String, FoodItem> foodMenuMap = menuMap.get(foodItem.getCategory());
        foodMenuMap.put(foodItem.getName(), foodItem);
        return foodItem;
    }

    public void removeItem(String itemName) throws BonVivantException {
        FoodItem delFoodItem = findFoodItem(itemName);
        if(delFoodItem == null){
            throw new BonVivantException("FoodItem does not exist.");
        }
        menuMap.get(delFoodItem.getCategory()).remove(delFoodItem.getName());
    }

    public void removeAll(){
        resetMenu();
    }

    private void resetMenu(){
        menuMap = new HashMap<>();
    }

}
