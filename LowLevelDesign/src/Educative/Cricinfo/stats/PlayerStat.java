package Educative.Cricinfo.stats;

public class PlayerStat extends Stat {
    private int ranking;
    private int bestScore;
    private int bestWicketCount;
    private int totalMatchesPlayed;
    private int total100s;
    private int totalHattricks;
    private int totalRuns;
    private int totalWickets;
    private int timesNotOut;
    private double battingAverage;
    private double bowlingAverage;

    public PlayerStat() {
    }

    // Call this after every match to update stats
    public void addMatchPerformance(int runs, boolean notOut, int wickets) {
        totalMatchesPlayed++;
        totalRuns += runs;
        totalWickets += wickets;
        if (runs > bestScore) bestScore = runs;
        if (wickets > bestWicketCount) bestWicketCount = wickets;
        if (runs >= 100) total100s++;
        if (wickets >= 3) totalHattricks++; // Example: treat 3 wickets as a hattrick
        if (notOut) timesNotOut++;
        updateStats();
    }

    public boolean updateStats() {
        // Batting average = total runs / (innings - not outs) [i.e., times out]
        int timesOut = totalMatchesPlayed - timesNotOut;
        if (timesOut > 0) {
            battingAverage = (double) totalRuns / timesOut;
        } else {
            battingAverage = 0.0; // Or Double.POSITIVE_INFINITY if never out
        }
        // Bowling average = total runs conceded / wickets taken
        // For simplicity, let's say each wicket is worth one run (replace with actual runs conceded if you track it)
        if (totalWickets > 0) {
            bowlingAverage = (double) totalRuns / totalWickets;
        } else {
            bowlingAverage = 0.0;
        }
        return true;
    }

    public int getRanking() {
        return ranking;
    }

    public int getBestScore() {
        return bestScore;
    }

    public int getBestWicketCount() {
        return bestWicketCount;
    }

    public int getTotalMatchesPlayed() {
        return totalMatchesPlayed;
    }

    public int getTotal100s() {
        return total100s;
    }

    public int getTotalHattricks() {
        return totalHattricks;
    }

    public int getTotalRuns() {
        return totalRuns;
    }

    public int getTotalWickets() {
        return totalWickets;
    }

    public int getTimesNotOut() {
        return timesNotOut;
    }

    public double getBattingAverage() {
        return battingAverage;
    }

    public double getBowlingAverage() {
        return bowlingAverage;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    public void setBestScore(int bestScore) {
        this.bestScore = bestScore;
    }

    public void setBestWicketCount(int bestWicketCount) {
        this.bestWicketCount = bestWicketCount;
    }

    public void setTotalMatchesPlayed(int totalMatchesPlayed) {
        this.totalMatchesPlayed = totalMatchesPlayed;
    }

    public void setTotal100s(int total100s) {
        this.total100s = total100s;
    }

    public void setTotalHattricks(int totalHattricks) {
        this.totalHattricks = totalHattricks;
    }

    public void setTotalRuns(int totalRuns) {
        this.totalRuns = totalRuns;
    }

    public void setTotalWickets(int totalWickets) {
        this.totalWickets = totalWickets;
    }

    public void setTimesNotOut(int timesNotOut) {
        this.timesNotOut = timesNotOut;
    }

    public void setBattingAverage(double battingAverage) {
        this.battingAverage = battingAverage;
    }

    public void setBowlingAverage(double bowlingAverage) {
        this.bowlingAverage = bowlingAverage;
    }
}
