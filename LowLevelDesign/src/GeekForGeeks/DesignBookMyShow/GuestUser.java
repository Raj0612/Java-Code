package GeekForGeeks.DesignBookMyShow;

public class GuestUser extends User {

    public boolean isRegistered;

    public GuestUser(String name) {
        super(name);
    }


    public void register(String name, String email, String pwd){
        isRegistered = true;
    }

}
