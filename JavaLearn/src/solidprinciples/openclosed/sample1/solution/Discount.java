package solidprinciples.openclosed.sample1.solution;

public class Discount implements PricedItem {
    private String name;
    private double amount;

    public Discount(String name, double amount) {
        this.name = name;
        this.amount = amount;
    }

    @Override
    public double getPrice() {
        return -amount; // Discounts are negative values
    }
}
