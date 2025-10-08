package Educative.Linkedin.profiledetails;

import java.time.LocalDate;

public class Recommendation {
    private int userId;
    private LocalDate createdOn;
    private String description;
    private boolean isAccepted;

    public Recommendation(int userId, LocalDate createdOn, String description, boolean isAccepted) {
        this.userId = userId;
        this.createdOn = createdOn;
        this.description = description;
        this.isAccepted = isAccepted;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public LocalDate getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDate createdOn) {
        this.createdOn = createdOn;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isAccepted() {
        return isAccepted;
    }

    public void setAccepted(boolean accepted) {
        isAccepted = accepted;
    }
}
