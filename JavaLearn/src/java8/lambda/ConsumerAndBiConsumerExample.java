package java8.lambda;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

//Consumer is a functional interface that has a single abstract method: void accept(T t) which accepts a single argument and returns nothing
//BiConsumer is a functional interface that has a single abstract method: void accept(T t, U u) which accepts two arguments and returns nothing
public class ConsumerAndBiConsumerExample {

    public static void main(String[] args) {

        Consumer<String> consumer = s -> System.out.println("Consumer : " + s); // Consumer<String>
        consumer.accept("Hello World");

        Consumer<String> printC = s -> System.out.println(s);// lambda expression
        printC.accept("Consumer lambda");

        List<String> names = new ArrayList<>();
        names.add("John");
        names.add("Mary");
        names.forEach(printC);

        names.forEach( s -> System.out.println(s));

        BiConsumer<String, String> biConsumer = (s1, s2) -> System.out.println("BiConsumer : " + s1 + " " + s2); // BiConsumer<String, String>
        biConsumer.accept("Hello World", "Hello World");

        Map<String, String> mapCapitalCities = new HashMap<String, String>(); // HashMap<String, String>
        String val = mapCapitalCities.put("Delhi", "India");
        System.out.println("mapCapitalCities val : " + val);
        String val1 = mapCapitalCities.put("Delhi", "India1");
        System.out.println("mapCapitalCities val1 : " + val1);
        BiConsumer<String, String> biCon = (key, value) -> mapCapitalCities.put(key, value); // BiConsumer<String, String>
        biCon.accept("Dublin", "Ireland");
        biCon.accept("Washington D.C.", "USA");
        System.out.println(mapCapitalCities);
    }
}
