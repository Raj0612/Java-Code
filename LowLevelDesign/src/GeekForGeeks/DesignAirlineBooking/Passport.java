package GeekForGeeks.DesignAirlineBooking;

public class Passport {

    public String passportNumber;
    public String dob;
    public Address address;
    public String expiryDate;

    public Passport(String passportNumber, String dob, Address address, String expiryDate) {
        this.passportNumber = passportNumber;
        this.dob = dob;
        this.address = address;
        this.expiryDate = expiryDate;
    }
}
