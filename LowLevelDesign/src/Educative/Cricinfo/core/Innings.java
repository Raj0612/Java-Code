package Educative.Cricinfo.core;

import Educative.Cricinfo.teams.Playing11;

import java.time.LocalDateTime;
import java.util.*;

public class Innings {
    private Playing11 bowling;
    private Playing11 batting;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private int totalScores;
    private int totalWickets;
    private List<Over> overs;

    public Innings(Playing11 bowling, Playing11 batting) {
        this.bowling = bowling;
        this.batting = batting;
        this.overs = new ArrayList<>();
        this.startTime = LocalDateTime.now();
    }

    public boolean addOver(Over over) {
        overs.add(over);
        return true;
    }

    public Playing11 getBowling() {
        return bowling;
    }

    public Playing11 getBatting() {
        return batting;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public int getTotalScores() {
        return totalScores;
    }

    public int getTotalWickets() {
        return totalWickets;
    }

    public List<Over> getOvers() {
        return Collections.unmodifiableList(overs);
    }

    public void setBowling(Playing11 bowling) {
        this.bowling = bowling;
    }

    public void setBatting(Playing11 batting) {
        this.batting = batting;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public void setTotalScores(int totalScores) {
        this.totalScores = totalScores;
    }

    public void setTotalWickets(int totalWickets) {
        this.totalWickets = totalWickets;
    }
}
