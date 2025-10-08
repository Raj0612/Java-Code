package Educative.RestaurantManagement.meals;

import Educative.RestaurantManagement.accounts.Chef;
import java.util.*;
public class Kitchen {
    private String name;
    private List<Chef> chefs;

    public Kitchen(String name) {
        this.name = name;
        this.chefs = new ArrayList<>();
    }

    public boolean assignChef(Chef chef) {
        chefs.add(chef);
        return true;
    }

    public List<Chef> getChefs() {
        return chefs;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
