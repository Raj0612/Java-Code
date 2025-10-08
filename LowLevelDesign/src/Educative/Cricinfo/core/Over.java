package Educative.Cricinfo.core;

import Educative.Cricinfo.accounts.Player;

import java.util.*;
import java.util.Collections;

public class Over {
    private int number;
    private Player bowler;
    private int totalScore;
    private List<Ball> balls;

    public Over(int number, Player bowler) {
        this.number = number;
        this.bowler = bowler;
        this.balls = new ArrayList<>();
    }

    public boolean addBall(Ball ball) {
        balls.add(ball);
        return true;
    }

    public int getNumber() {
        return number;
    }

    public Player getBowler() {
        return bowler;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public List<Ball> getBalls() {
        return Collections.unmodifiableList(balls);
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setBowler(Player bowler) {
        this.bowler = bowler;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }
}
