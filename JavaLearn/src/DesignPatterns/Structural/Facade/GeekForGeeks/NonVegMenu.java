package DesignPatterns.Structural.Facade.GeekForGeeks;

import java.util.Arrays;
import java.util.List;

public class NonVegMenu implements Menus {

    @Override
    public List<String> getItems() {
        return Arrays.asList(
                "Chicken Biryani",
                "Mutton Curry",
                "Fish Fry",
                "Egg Curry"
        );
    }
}
