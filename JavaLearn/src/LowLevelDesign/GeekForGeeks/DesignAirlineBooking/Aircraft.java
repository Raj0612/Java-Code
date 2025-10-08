package LowLevelDesign.GeekForGeeks.DesignAirlineBooking;

public class Aircraft {
    public String name, model, manufacturingYear;
    public int seats;

    public Aircraft(String name, String model, String manufacturingYear, int seats) {
        this.name = name;
        this.model = model;
        this.manufacturingYear = manufacturingYear;
        this.seats = seats;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getManufacturingYear() {
        return manufacturingYear;
    }

    public void setManufacturingYear(String manufacturingYear) {
        this.manufacturingYear = manufacturingYear;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }
}
