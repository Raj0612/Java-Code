package Educative.CarRentalSyatem.account;

import Educative.CarRentalSyatem.enums.AccountStatus;

import java.time.LocalDate;
import java.util.UUID;

public class Customer extends Account{
    private String licenseNumber;
    private LocalDate licenseExpiry;

    public Customer() {}

    public Customer(String accountId, String password, AccountStatus status,
                    String name, Address address, String email, String phoneNumber,
                    String licenseNumber, LocalDate licenseExpiry) {
        super(accountId, password, status, name, address, email, phoneNumber);
        this.licenseNumber = licenseNumber;
        this.licenseExpiry = licenseExpiry;
    }

    public String getLicenseNumber() { return licenseNumber; }
    public void setLicenseNumber(String licenseNumber) { this.licenseNumber = licenseNumber; }
    public LocalDate getLicenseExpiry() { return licenseExpiry; }
    public void setLicenseExpiry(LocalDate licenseExpiry) { this.licenseExpiry = licenseExpiry; }

    @Override
    public boolean resetPassword() {
        this.setPassword(UUID.randomUUID().toString());
        return true;
    }
}
