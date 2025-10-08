package GeekForGeeks.DesignElevatorSystem.button;

public abstract class Button {

    public boolean status;

    public void pressDown(){
        status = true;
    }

    public boolean isPressed(){
        return status;
    }

}
