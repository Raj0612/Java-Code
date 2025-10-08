package solidprinciples.liskovSubstitution.sample3.problem;

public class Mocktail extends Briyani{

    public  Mocktail(int price, String name){
        super(price, name);
    }

    public double getPriceWithDiscount(){
        return this.price - 10;
    }
}
