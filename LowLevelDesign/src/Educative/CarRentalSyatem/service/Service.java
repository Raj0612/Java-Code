package Educative.CarRentalSyatem.service;

public abstract class Service {
    private int serviceId;
    private int price;

    public Service() {
    }

    public Service(int serviceId, int price) {
        this.serviceId = serviceId;
        this.price = price;
    }

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
