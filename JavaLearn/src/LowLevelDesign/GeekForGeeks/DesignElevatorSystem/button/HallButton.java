package LowLevelDesign.GeekForGeeks.DesignElevatorSystem.button;

import LowLevelDesign.GeekForGeeks.DesignElevatorSystem.ElevatorCar;

public class HallButton extends Button{

    private String buttonSign;
    private int sourceFloorNumber;

    private ElevatorCar elevatorCar;

    public HallButton(String buttonSign, int sourceFloorNumber) {
        this.buttonSign = buttonSign;
        this.sourceFloorNumber = sourceFloorNumber;
    }

    public String getButtonSign() {
        return buttonSign;
    }

    public void setButtonSign(String buttonSign) {
        this.buttonSign = buttonSign;
    }

    public int getSourceFloorNumber() {
        return sourceFloorNumber;
    }

    public void setSourceFloorNumber(int sourceFloorNumber) {
        this.sourceFloorNumber = sourceFloorNumber;
    }


    public ElevatorCar getElevatorCar() {
        return elevatorCar;
    }

    public void setElevatorCar(ElevatorCar elevatorCar) {
        this.elevatorCar = elevatorCar;
    }
}
