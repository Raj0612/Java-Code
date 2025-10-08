package DesignPatterns.Structural.Facade.discount;

import java.math.BigDecimal;

public class Product {

    private long idProduct;
    private String name;
    private BigDecimal price;

    public Product(long idProduct, String name, BigDecimal price) {
        this.idProduct = idProduct;
        this.name = name;
        this.price = price;
    }

    public long getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(long idProduct) {
        this.idProduct = idProduct;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
