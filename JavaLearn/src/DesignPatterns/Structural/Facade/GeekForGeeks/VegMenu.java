package DesignPatterns.Structural.Facade.GeekForGeeks;

import java.util.*;

public class VegMenu implements Menus {
    @Override
    public List<String> getItems() {
        return Arrays.asList(
                "Paneer Butter Masala",
                "Veg Biryani",
                "Dal Tadka",
                "Aloo Paratha"
        );
    }
}
