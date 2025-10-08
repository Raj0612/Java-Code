package solidprinciples.liskovSubstitution.sample2.solution;

public class Duck extends Bird {
    @Override
    public void fly() {
        System.out.println("Flying like a duck...");
    }
}
