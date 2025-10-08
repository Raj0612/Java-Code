package GeekForGeeks.DesignBookMyShow;

import java.util.ArrayList;

public class RegisteredUser extends User {

    private boolean isLoggedIn;
    private ArrayList<Ticket> bookingHistory;

    public RegisteredUser(String name) {
        super(name);
        bookingHistory = new ArrayList<>();
    }

    public void login(String email, String pwd){
        isLoggedIn = true;
    }
}
