package LowLevelDesign.GitLab.Shrayansh8.LLDSnakeLadder;

public class Player {

    String id;
    int currentPosition;

    public Player(String id, int currentPosition) {
        this.id = id;
        this.currentPosition = currentPosition;
    }

    //getters and setters

    public int getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(int currentPosition) {
        this.currentPosition = currentPosition;
    }
}
