package solidprinciples.liskovSubstitution.sample3.solution;

import solidprinciples.liskovSubstitution.sample3.problem.Briyani;

public class Mocktail extends Briyani {

    public  Mocktail(int price, String name){
        super(price, name);
    }

    public double getPrice(){
        return this.price - this.getDiscount();
    }

    private double getDiscount(){
        return 10;
    }
}

