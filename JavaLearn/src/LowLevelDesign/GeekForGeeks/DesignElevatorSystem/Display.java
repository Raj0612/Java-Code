package LowLevelDesign.GeekForGeeks.DesignElevatorSystem;

public class Display {

    private int floor;
    private String direction;

    public void showElevatorDisplay(int floor, String direction){
        this.floor = floor;
        this.direction = direction;
        System.out.println("Elevator at floor: " + floor + " , direction: " + direction);
    }

    public void showHallDisplay(int floor, String direction){
        System.out.println("Hall display - floor: " + floor + " , direction: " + direction);
    }
}
