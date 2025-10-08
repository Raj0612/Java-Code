package DesignPatterns.Structural.Facade.discount;

public class ApplyDiscountRequest {

    private long idCustomer;
    private long idProduct;
    private long idDiscount;

    public ApplyDiscountRequest(long idCustomer, long idProduct, long idDiscount) {
        this.idCustomer = idCustomer;
        this.idProduct = idProduct;
        this.idDiscount = idDiscount;
    }

    public long getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(long idCustomer) {
        this.idCustomer = idCustomer;
    }

    public long getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(long idProduct) {
        this.idProduct = idProduct;
    }

    public long getIdDiscount() {
        return idDiscount;
    }

    public void setIdDiscount(long idDiscount) {
        this.idDiscount = idDiscount;
    }
}
