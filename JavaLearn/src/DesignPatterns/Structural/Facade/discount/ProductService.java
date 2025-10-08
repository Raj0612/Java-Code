package DesignPatterns.Structural.Facade.discount;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class ProductService {

    private Map<Long, Product> products = new HashMap<>();

    public ProductService() {
        products.put(1L, new Product(1L, "POS", new BigDecimal("100")));
    }

    public Product findProductBy(long idProduct) {
        return products.get(idProduct);
    }

}
