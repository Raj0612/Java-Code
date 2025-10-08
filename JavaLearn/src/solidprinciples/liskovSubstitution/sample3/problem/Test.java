package solidprinciples.liskovSubstitution.sample3.problem;

public class Test {
    public static void main(String[] args) {
        Briyani c1 = new Briyani(300, "Briyani");
        Mocktail c2 = new Mocktail(50, "Coke");
        System.out.println( c1.getPrice());
        System.out.println( c2.getPrice());
        System.out.println( c2.getPriceWithDiscount());
    }
}
