package Educative.HotelManagement.services;

import Educative.HotelManagement.invoices.Invoice;

public class KitchenService extends Service {
    private String description;
    public KitchenService(String desc) {
        this.description = desc;
    }
    public boolean addInvoiceItem(Invoice invoice) {
        invoice.addAmount(25.0);
        return true;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

