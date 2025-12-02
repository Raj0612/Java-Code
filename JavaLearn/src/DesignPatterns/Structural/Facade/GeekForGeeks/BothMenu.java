package DesignPatterns.Structural.Facade.GeekForGeeks;

import java.util.ArrayList;
import java.util.List;

public class BothMenu implements Menus {

    @Override
    public List<String> getItems() {
        List<String> items = new ArrayList<>();

        items.addAll(new VegMenu().getItems());
        items.addAll(new NonVegMenu().getItems());

        return items;
    }
}