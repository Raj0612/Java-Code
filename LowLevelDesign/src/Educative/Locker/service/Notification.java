package Educative.Locker.service;

public class Notification {

    private String customerId;
    private String orderId;
    private String lockerId;
    private String code;

    public Notification(String customerId, String orderId, String lockerId, String code) {
        this.customerId = customerId;
        this.orderId = orderId;
        this.lockerId = lockerId;
        this.code = code;
    }

    public void send(){
        System.out.println("Notification send to customer: " + this.customerId);
    }


    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getLockerId() {
        return lockerId;
    }

    public void setLockerId(String lockerId) {
        this.lockerId = lockerId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
