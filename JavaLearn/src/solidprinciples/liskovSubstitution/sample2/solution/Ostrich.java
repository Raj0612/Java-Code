package solidprinciples.liskovSubstitution.sample2.solution;

public class Ostrich extends Bird {
    @Override
    public void fly() {
        System.out.println("Oops! Ostrich can't fly...");
    }

    @Override
    public boolean canFly() {
        return false;
    }
}
