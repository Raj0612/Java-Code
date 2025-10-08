package Educative.StackOverFlow1.accounts;

public class Reputation {
    private int points;

    public Reputation(int initial) {
        this.points = Math.max(0, initial);
    }

    public int getPoints() {
        return points;
    }

    public void add(int delta) {
        points = Math.max(0, points + delta);
    }

    public boolean canCreateTag() {
        return points >= 1500;
    }

    public boolean canVoteToClose() {
        return points >= 3000;
    }

    @Override
    public String toString() {
        return String.valueOf(points);
    }
}
