package learn.java8features.methodreference;

import java.util.Arrays;
import java.util.List;

interface FuncInterface {
    void abstractFun(int x);

    default void normalFun() {
        System.out.println("Hello");
    }
}

public class MethodReference {

    // Static method to be used in method reference
    static void printDouble(int x) {
        System.out.println(2 * x);
    }

    public static void main(String args[]) {

        List<Integer> list = Arrays.asList(
                234, 780, 451, 639, 456, 98, 75, 43);

        System.out.println("list " + list);

        // Using Lambda expression
        FuncInterface lambdaObj = (int x) -> System.out.println(2 * x);
        lambdaObj.abstractFun(5);

        // Using Method reference to a static method
        FuncInterface methodRefObj = MethodReference::printDouble;
        methodRefObj.abstractFun(5);
    }
}
