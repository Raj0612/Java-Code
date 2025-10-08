package Educative.Cricinfo.stats;

import Educative.Cricinfo.accounts.Player;

public class MatchStat extends Stat {
    private double winPercentage;
    private Player topBatsman;
    private Player topBowler;

    public MatchStat() {
    }

    public boolean updateStats() {
        return true;
    }

    public double getWinPercentage() {
        return winPercentage;
    }

    public Player getTopBatsman() {
        return topBatsman;
    }

    public Player getTopBowler() {
        return topBowler;
    }

    public void setWinPercentage(double winPercentage) {
        this.winPercentage = winPercentage;
    }

    public void setTopBatsman(Player topBatsman) {
        this.topBatsman = topBatsman;
    }

    public void setTopBowler(Player topBowler) {
        this.topBowler = topBowler;
    }
}
