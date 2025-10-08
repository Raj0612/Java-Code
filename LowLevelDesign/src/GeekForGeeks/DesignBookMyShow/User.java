package GeekForGeeks.DesignBookMyShow;

public abstract class User {

    private static int idCounter;
    private  int id;
    private String name;

    public User(String name) {
        idCounter++;
        this.id = idCounter;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
