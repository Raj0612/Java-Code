package GeekForGeeks.DesignElevatorSystem.button;

import GeekForGeeks.DesignElevatorSystem.ElevatorCar;

public class HallButton extends Button{

    private String buttonSign;
    private int sourceFloorNumber;

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

}
