package Educative.OnlineShopping.search;

import Educative.OnlineShopping.products.Product;

import java.util.List;

public interface Search {
    List<Product> searchProductsByName(String name);
    List<Product> searchProductsByCategory(String category);
}
