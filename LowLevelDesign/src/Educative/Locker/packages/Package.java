package Educative.Locker.packages;

import Educative.Locker.orders.Order;

public class Package {

    private String packageId;
    private double packageSize;
    private Order order;

    public Package(String packageId, double packageSize) {
        this.packageId = packageId;
        this.packageSize = packageSize;
    }
    public void pack(Order order) {
        this.order = order;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public String getPackageId() {
        return packageId;
    }

    public void setPackageId(String packageId) {
        this.packageId = packageId;
    }

    public double getPackageSize() {
        return packageSize;
    }

    public void setPackageSize(double packageSize) {
        this.packageSize = packageSize;
    }
}
