package Educative.StackOverFlow1.features;

import Educative.StackOverFlow1.accounts.User;

import java.time.LocalDateTime;

public class Bounty {
    private final int reputationPoints;
    private final User offeredBy;
    private final LocalDateTime createdAt;
    private final LocalDateTime expiresAt;
    private boolean awarded = false;

    public Bounty(User offeredBy, int points, int daysValid) {
        this.offeredBy = offeredBy;
        this.reputationPoints = points;
        this.createdAt = LocalDateTime.now();
        this.expiresAt = createdAt.plusDays(daysValid);
    }

    public boolean isExpired() {
        return LocalDateTime.now().isAfter(expiresAt);
    }

    public int getPoints() {
        return reputationPoints;
    }

    public User getOfferedBy() {
        return offeredBy;
    }

    public void markAwarded() {
        awarded = true;
    }

    public boolean isAwarded() {
        return awarded;
    }
}
