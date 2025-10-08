package LowLevelDesign.Github.niteshkumartiwari.BookingDotCom.dto;

public class RatingReport {
    private int numberOfRatings;
    private Double averageRating;

    public RatingReport() {}

    public RatingReport(int numberOfRatings, Double averageRating) {
        this.numberOfRatings = numberOfRatings;
        this.averageRating = averageRating;
    }

    public int getNumberOfRatings() {
        return numberOfRatings;
    }

    public void setNumberOfRatings(int numberOfRatings) {
        this.numberOfRatings = numberOfRatings;
    }

    public Double getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(Double averageRating) {
        this.averageRating = averageRating;
    }
}
