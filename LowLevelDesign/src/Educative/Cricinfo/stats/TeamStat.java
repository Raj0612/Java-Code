package Educative.Cricinfo.stats;

public class TeamStat extends Stat {
    private int totalSixes;
    private int totalFours;
    private int totalReviews;
    private int totalRunsScored;
    private int totalWicketsTaken;
    private int totalMatchesPlayed;
    private int totalMatchesWon;
    private double winPercentage;

    public TeamStat() {
    }

    // Call this after each match
    public void addMatchPerformance(int sixes, int fours, int reviews, int runsScored, int wicketsTaken, boolean won) {
        totalMatchesPlayed++;
        totalSixes += sixes;
        totalFours += fours;
        totalReviews += reviews;
        totalRunsScored += runsScored;
        totalWicketsTaken += wicketsTaken;
        if (won) totalMatchesWon++;
        updateStats();
    }

    @Override
    public boolean updateStats() {
        if (totalMatchesPlayed > 0) {
            winPercentage = (double) totalMatchesWon * 100.0 / totalMatchesPlayed;
        } else {
            winPercentage = 0.0;
        }
        // You could add more advanced calculations here, such as average runs per match, average wickets per match, etc.
        return true;
    }

    // Getters and setters
    public int getTotalSixes() {
        return totalSixes;
    }

    public int getTotalFours() {
        return totalFours;
    }

    public int getTotalReviews() {
        return totalReviews;
    }

    public int getTotalRunsScored() {
        return totalRunsScored;
    }

    public int getTotalWicketsTaken() {
        return totalWicketsTaken;
    }

    public int getTotalMatchesPlayed() {
        return totalMatchesPlayed;
    }

    public int getTotalMatchesWon() {
        return totalMatchesWon;
    }

    public double getWinPercentage() {
        return winPercentage;
    }

    public void setTotalSixes(int totalSixes) {
        this.totalSixes = totalSixes;
    }

    public void setTotalFours(int totalFours) {
        this.totalFours = totalFours;
    }

    public void setTotalReviews(int totalReviews) {
        this.totalReviews = totalReviews;
    }

    public void setTotalRunsScored(int totalRunsScored) {
        this.totalRunsScored = totalRunsScored;
    }

    public void setTotalWicketsTaken(int totalWicketsTaken) {
        this.totalWicketsTaken = totalWicketsTaken;
    }

    public void setTotalMatchesPlayed(int totalMatchesPlayed) {
        this.totalMatchesPlayed = totalMatchesPlayed;
    }

    public void setTotalMatchesWon(int totalMatchesWon) {
        this.totalMatchesWon = totalMatchesWon;
    }

    public void setWinPercentage(double winPercentage) {
        this.winPercentage = winPercentage;
    }
}