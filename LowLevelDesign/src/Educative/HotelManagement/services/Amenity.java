package Educative.HotelManagement.services;

import Educative.HotelManagement.invoices.Invoice;

public class Amenity extends Service {
    private String name, description;
    public Amenity(String name, String desc) {
        this.name = name;
        this.description = desc;
    }
    public boolean addInvoiceItem(Invoice invoice) {
        invoice.addAmount(20.0);
        return true;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
