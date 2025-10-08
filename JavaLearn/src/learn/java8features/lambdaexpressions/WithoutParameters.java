package learn.java8features.lambdaexpressions;

interface Test1 {
    void print();
}

interface Sayable {
     String say();
}
public class WithoutParameters {
    static void fun(Test1 t) { t.print(); }
    public static void main(String[] args) {
        fun(() -> System.out.println("Hello"));

        Sayable sayable = new Sayable() {
            @Override
            public String say() {
                return "Return something ..";
            }
        };
        sayable.say();

        Sayable withLambda = () -> "Return something ..";
        withLambda.say();
    }



}
