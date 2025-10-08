package solidprinciples.liskovSubstitution.sample2.problem;

public class Duck extends Bird {
    @Override
    public void fly() {
        System.out.println("Flying like a duck...");
    }
}
