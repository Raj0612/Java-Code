package Educative.Linkedin.profiledetails;

public class Analytics {
    private int searchAppearances;
    private int profileViews;
    private int postImpressions;
    private int totalConnections;
    private int follows;

    public Analytics(int searchAppearances, int profileViews, int postImpressions, int totalConnections) {
        this.searchAppearances = searchAppearances;
        this.profileViews = profileViews;
        this.postImpressions = postImpressions;
        this.totalConnections = totalConnections;
    }

    public void incrementPostImpressions() {
        postImpressions++;
    }

    public void incrementProfileViews() {
        profileViews++;
    }

    public void incrementConnections() {
        totalConnections++;
    }

    public void decrementConnections() {
        totalConnections--;
    }

    public void incrementFollows() {
        follows++;
    }

    public void decrementFollows() {
        follows--;
    }

    public void incrementSearchAppearances() {
        searchAppearances++;
    }

    public void setTotalConnections(int totalConnections) {
        this.totalConnections = totalConnections;
    }

    public int getSearchAppearances() {
        return searchAppearances;
    }

    public void setSearchAppearances(int searchAppearances) {
        this.searchAppearances = searchAppearances;
    }

    public int getProfileViews() {
        return profileViews;
    }

    public void setProfileViews(int profileViews) {
        this.profileViews = profileViews;
    }

    public int getPostImpressions() {
        return postImpressions;
    }

    public void setPostImpressions(int postImpressions) {
        this.postImpressions = postImpressions;
    }

    public int getTotalConnections() {
        return totalConnections;
    }

    public void setTotalConnections() {
        this.totalConnections = totalConnections;
    }

    public int getFollows() {
        return follows;
    }

}
