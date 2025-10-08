package solidprinciples.openclosed.sample1.problem;

public class Service {
    private String name;
    private double hourlyRate;
    private int hours;

    public Service(String name, double hourlyRate,
                   int hours) {
        this.name = name;
        this.hourlyRate = hourlyRate;
        this.hours = hours;
    }

    public double getPrice() {
        return hourlyRate * hours;
    }
}
