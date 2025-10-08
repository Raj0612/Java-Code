package Educative.ParkingLot.accounts;

public class Address {
    private int zipCode;
    private String street;
    private String city;
    private String state;
    private String country;

    public Address(int zipCode, String street, String city, String state, String country) {
        this.zipCode = zipCode;
        this.street = street;
        this.city = city;
        this.state = state;
        this.country = country;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}

