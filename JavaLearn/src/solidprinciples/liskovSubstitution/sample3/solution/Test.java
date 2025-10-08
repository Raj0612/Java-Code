package solidprinciples.liskovSubstitution.sample3.solution;


public class Test {

    public static void main(String[] args) {
        Briyani c1 = new Briyani(300, "Nob Veg");
        Mocktail c2 = new Mocktail(50, "coke");
        System.out.println( c1.getPrice());
        System.out.println( c2.getPrice());
    }


}
