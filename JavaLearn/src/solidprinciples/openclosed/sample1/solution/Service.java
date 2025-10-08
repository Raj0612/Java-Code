package solidprinciples.openclosed.sample1.solution;

public class Service implements PricedItem{

    private String name;
    private double hourlyRate;
    private int hours;

    public Service(String name, double hourlyRate,
                   int hours) {
        this.name = name;
        this.hourlyRate = hourlyRate;
        this.hours = hours;
    }

    @Override
    public double getPrice() {
        return hourlyRate * hours;
    }
}
