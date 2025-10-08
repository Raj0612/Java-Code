package Educative.RestaurantManagement.menus;
import java.util.*;
public class MenuSection {

    private int menuSectionID;
    private String title;
    private String description;
    private List<MenuItem> menuItems;

    public MenuSection(int menuSectionID, String title, String description) {
        this.menuSectionID = menuSectionID;
        this.title = title;
        this.description = description;
        this.menuItems = new ArrayList<>();
    }

    public boolean addMenuItem(MenuItem menuItem) {
        menuItems.add(menuItem);
        return true;
    }

    public boolean print() {
        System.out.println("  Section: " + title);
        for (MenuItem item : menuItems) {
            System.out.println("    " + item.getTitle() + " - $" + item.getPrice());
        }
        return true;
    }

    public int getMenuSectionID() {
        return menuSectionID;
    }

    public void setMenuSectionID(int menuSectionID) {
        this.menuSectionID = menuSectionID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }
}
