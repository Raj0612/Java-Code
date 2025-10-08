package LowLevelDesign.GeekForGeeks.DesignAirlineBooking;

import LowLevelDesign.GeekForGeeks.DesignAirlineBooking.enums.AccountStatus;

public class Account {

    public String id, password;
    public AccountStatus status;
    public String name, email, phone;
    public Passport passport;

    public Account(String id, String password, String name, String email, String phone, Passport passport) {
        this.id = id;
        this.password = password;
        this.status = AccountStatus.ACTIVE;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.passport = passport;
    }
}
