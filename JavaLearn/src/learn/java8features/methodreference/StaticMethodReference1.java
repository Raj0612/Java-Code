package learn.java8features.methodreference;

import java.util.function.BiFunction;
class Arithmetic {
    public static int add(int a, int b) {
        return a + b;
    }

    public static float add(int a, float b) {
        return a + b;
    }

    public static float add(float a, float b) {
        return a + b;
    }
}
public class StaticMethodReference1 {

    public static void main(String[] args) {
        BiFunction<Integer, Integer, Integer> adder = (a, b) -> a+b;
        System.out.println("adder " + adder.apply(4, 7));

        BiFunction<Integer, Integer, Integer> adder1 = Arithmetic::add;
        BiFunction<Integer, Float, Float> adder2 = Arithmetic::add;
        BiFunction<Float, Float, Float> adder3 = Arithmetic::add;
        int result1 = adder1.apply(10, 20);
        float result2 = adder2.apply(10, 20.0f);
        float result3 = adder3.apply(10.0f, 20.0f);
        System.out.println("adder1 " + result1);
        System.out.println("adder2 " + result2);
        System.out.println("adder3" + result3);
    }
}
