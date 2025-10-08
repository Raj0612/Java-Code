package Educative.Locker.packages;

import java.util.Date;

public class LockerPackage extends Package {
    private int codeValidDays;
    private String lockerId;
    private String packageId;
    private String code;
    private Date packageDeliveryTime;

    public LockerPackage(String packageId, double packageSize, int codeValidDays, String lockerId, String code, Date packageDeliveryTime) {
        super(packageId, packageSize);  // Call to parent class constructor
        this.codeValidDays = codeValidDays;
        this.lockerId = lockerId;
        this.code = code;
        this.packageDeliveryTime = packageDeliveryTime;
    }

    public boolean isValidCode(){
        return true;
    }
    public boolean verifyCode(String code){
        return this.code.equals(code);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getCodeValidDays() {
        return codeValidDays;
    }

    public void setCodeValidDays(int codeValidDays) {
        this.codeValidDays = codeValidDays;
    }

    public String getLockerId() {
        return lockerId;
    }

    public void setLockerId(String lockerId) {
        this.lockerId = lockerId;
    }

    public Date getPackageDeliveryTime() {
        return packageDeliveryTime;
    }

    public void setPackageDeliveryTime(Date packageDeliveryTime) {
        this.packageDeliveryTime = packageDeliveryTime;
    }

    public String getPackageId() {
        return packageId;
    }

    public void setPackageId(String packageId) {
        this.packageId = packageId;
    }
}
