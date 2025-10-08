package solidprinciples.openclosed.sample1.problem;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<Object> items;

    public ShoppingCart() {
        this.items = new ArrayList<>();
    }

    public void addItem(Object item) {
        items.add(item);
    }

    public double calculateTotal() {
        double total = 0.0;
        for (Object item : items) {
            if (item instanceof Product) {
                total += ((Product) item).getPrice();
            } else if (item instanceof Service) {
                total += ((Service) item).getPrice();
            }
        }
        return total;
    }
}
