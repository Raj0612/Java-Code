package solidprinciples.liskovSubstitution.sample3.solution;

public class Briyani {

    public int price;
    public String name;
    public String description;

    public Briyani(int price, String name){
        this.price = price;
        this.name = name;
    }

    public double getPrice(){
        return this.price - this.getDiscount();
    }

    private double getDiscount(){
        return 0;
    }

}
