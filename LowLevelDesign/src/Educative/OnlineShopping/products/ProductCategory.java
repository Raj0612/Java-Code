package Educative.OnlineShopping.products;

import java.util.ArrayList;
import java.util.List;

public class ProductCategory {
    private String name;
    private String description;
    private List<Product> products;

    public ProductCategory(String name, String description) {
        this.name = name;
        this.description = description;
        this.products = new ArrayList<>();
    }

    public String getName() { return name; }
    public String getDescription() { return description; }
    public List<Product> getProducts() { return products; }

    public void addProduct(Product product) {
        products.add(product);
    }
}
