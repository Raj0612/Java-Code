package Educative.HotelManagement.services;

import Educative.HotelManagement.invoices.Invoice;

import java.time.LocalDateTime;

public class RoomService extends Service {
    private boolean isChargeable;
    private LocalDateTime requestTime;
    public RoomService(boolean chargeable) {
        this.isChargeable = chargeable;
        this.requestTime = LocalDateTime.now();
    }
    public boolean addInvoiceItem(Invoice invoice) {
        invoice.addAmount(isChargeable ? 15.0 : 0.0);
        return true;
    }

    public boolean isChargeable() {
        return isChargeable;
    }

    public void setChargeable(boolean chargeable) {
        isChargeable = chargeable;
    }

    public LocalDateTime getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(LocalDateTime requestTime) {
        this.requestTime = requestTime;
    }
}