package learn.java8features.lambdaexpressions;

interface Test2 {
    void print(Integer p);
}

interface Printable {
    void print(String msg);
}
public class SingleParameter {
    static void fun(Test2 t, Integer p){
        t.print(p);
    }
    public static void main(String[] args) {

        fun(p -> System.out.println(p), 10);


        Printable withLambda = msg -> System.out.println(msg);
        withLambda.print(" Print message to console....");
    }
}
