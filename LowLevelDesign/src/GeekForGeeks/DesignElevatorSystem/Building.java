package GeekForGeeks.DesignElevatorSystem;

public class Building {

    private Floor[] floors;
    private ElevatorCar[] elevatorCars;

    public Building(int totalFloors, int elevatorCount){
        floors = new Floor[totalFloors];
        for(int i =0; i< totalFloors; i++){
            floors[i] = new Floor(i);
        }

        elevatorCars = new ElevatorCar[elevatorCount];
        for(int i=0; i< elevatorCount; i++){
            elevatorCars[i] = new ElevatorCar(i, totalFloors);
        }
    }

    public Floor[] getFloors() {
        return floors;
    }

    public ElevatorCar[] getElevatorCars() {
        return elevatorCars;
    }
}
