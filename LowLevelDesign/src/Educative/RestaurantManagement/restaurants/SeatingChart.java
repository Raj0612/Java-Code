package Educative.RestaurantManagement.restaurants;

public class SeatingChart {

    private int seatingChartID;
    private byte[] seatingChartImage;

    public SeatingChart(int seatingChartID, byte[] seatingChartImage) {
        this.seatingChartID = seatingChartID;
        this.seatingChartImage = seatingChartImage;
    }

    public boolean print() {
        System.out.println("Printing seating chart...");
        return true;
    }

    public int getSeatingChartID() {
        return seatingChartID;
    }

    public void setSeatingChartID(int seatingChartID) {
        this.seatingChartID = seatingChartID;
    }

    public byte[] getSeatingChartImage() {
        return seatingChartImage;
    }

    public void setSeatingChartImage(byte[] seatingChartImage) {
        this.seatingChartImage = seatingChartImage;
    }
}
