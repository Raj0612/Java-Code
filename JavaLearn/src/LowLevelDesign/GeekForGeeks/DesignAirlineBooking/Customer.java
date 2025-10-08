package LowLevelDesign.GeekForGeeks.DesignAirlineBooking;

public class Customer extends Account {

    public boolean frequentFlyer;

    Customer(String id, String password, String name, String email, String phone, Passport pass){
        super(id, password, name, email, phone, pass);
    }

    Customer(String id, String password, String name, String email, String phone, Passport pass, boolean frequentFlyer){
        super(id, password, name, email, phone, pass);
        this.frequentFlyer = frequentFlyer;
    }
}
