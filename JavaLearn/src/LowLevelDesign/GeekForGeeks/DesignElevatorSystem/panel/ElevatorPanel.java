package LowLevelDesign.GeekForGeeks.DesignElevatorSystem.panel;

import LowLevelDesign.GeekForGeeks.DesignElevatorSystem.button.ElevatorButton;

public class ElevatorPanel {

    private ElevatorButton[] floorButtons;
    private ElevatorButton openButton;
    private ElevatorButton closeButton;

    public ElevatorPanel(int totalFloors){
        floorButtons= new ElevatorButton[totalFloors];
        for(int i=0; i<totalFloors; i++){
            floorButtons[i] = new ElevatorButton(i);
        }
        openButton = new ElevatorButton(-1);
        closeButton = new ElevatorButton(-1);
    }

    public ElevatorButton[] getFloorButtons(){
        return floorButtons;
    }
}
