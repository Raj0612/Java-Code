package solidprinciples.openclosed.sample1.solution;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<PricedItem> items;
    public ShoppingCart() {
        this.items = new ArrayList<>();
    }

    public void addItem(PricedItem item) {
        items.add(item);
    }

    public double calculateTotal() {
        double total = 0.0;
        for (PricedItem item : items) {
            total += item.getPrice();
        }
        return total;
    }
}
