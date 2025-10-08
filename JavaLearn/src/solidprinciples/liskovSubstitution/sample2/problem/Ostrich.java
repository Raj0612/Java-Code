package solidprinciples.liskovSubstitution.sample2.problem;

public class Ostrich extends Bird {
    @Override
    public void fly() {
        System.out.println("Oops! Ostrich can't fly...");
    }
}
