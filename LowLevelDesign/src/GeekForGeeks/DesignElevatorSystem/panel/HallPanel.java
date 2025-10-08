package GeekForGeeks.DesignElevatorSystem.panel;

import GeekForGeeks.DesignElevatorSystem.button.HallButton;

public class HallPanel {
    private HallButton upButton;
    private HallButton downButton;

    public HallPanel(int floor) {
        this.upButton = new HallButton("UP", floor);
        this.downButton = new HallButton("DOWN", floor);
    }

    public HallButton getUpButton() {
        return upButton;
    }

    public HallButton getDownButton() {
        return downButton;
    }
}
