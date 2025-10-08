package learn.java8features.udemy.seankennedy.lambda;

public class ABasicLambdas {

    public static void main(String[] args) {

        I i = new I() {
            @Override
            public void m() {
                System.out.println("Prior to Java 8");
            }
        };

        i.m();

        I lambda = () ->{
            System.out.println("Java 8");
        };

        lambda.m();

    }
}

interface I{
    void m();
}
