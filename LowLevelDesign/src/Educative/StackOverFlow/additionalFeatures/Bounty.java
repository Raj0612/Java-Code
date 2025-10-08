package Educative.StackOverFlow.additionalFeatures;

import java.time.LocalDate;

public class Bounty {
    private int reputationPoints;
    private LocalDate expiryDate;

    public Bounty(int reputationPoints, LocalDate expiryDate) {
        this.reputationPoints = reputationPoints;
        this.expiryDate = expiryDate;
    }

    public boolean updateReputationPoints(int reputation) {
        if (reputation > 0) {
            this.reputationPoints = reputation;
            return true;
        }
        return false;
    }

    public int getReputationPoints() {
        return reputationPoints;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }
}
