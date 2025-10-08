package GeekForGeeks.DesignElevatorSystem;

import GeekForGeeks.DesignElevatorSystem.panel.HallPanel;

public class Floor {
    private int floorNumber;
    private HallPanel hallPanel;

    public Floor(int floorNumber) {
        this.floorNumber = floorNumber;
        this.hallPanel = new HallPanel(floorNumber);
    }

    public boolean isBottomMost(){
        return floorNumber == 0;
    }

    public boolean isTopMost(int totalFloors){
        return floorNumber == totalFloors-1;
    }

    public HallPanel getHallPanel(){
        return hallPanel;
    }
}
