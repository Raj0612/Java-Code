package learn.java8features.streamapi;

import java.util.stream.Stream;

public class TerminalOperations {

    public static void main(String[] args) {

        String name = Stream.of("r", "a", "j")
                .reduce("nothing", (s1, s2) -> s1 + s2);
              //  .reduce((s1, s2) -> s1 + s2)
                //.get();
        System.out.println(name);

        Integer product = Stream.of(1, 2, 3, 4)
                .reduce(2, (s1, s2) -> s1 * s2);
        System.out.println("product " + product);

        Integer max = Stream.of(1, 2, 3, 4)
                .reduce(1, (s1, s2) -> s1 > s2 ? s1 : s2);
        System.out.println(max);

        Integer min = Stream.of(1, 2, 3, 4)
                .reduce(1, (s1, s2) -> s1 < s2 ? s1 : s2);
        System.out.println(min);

        Integer sum = Stream.of(1, 2, 3, 4)
                .reduce(1, (s1, s2) -> s1 + s2);
        System.out.println(sum);


        Stream<String> stream = Stream.of("car", "bus");
        int len = stream.reduce(0, (n, str) -> n + str.length(),
                (n1, n2) -> n1 + n2);
        System.out.println("Len " + len);


        Stream<String> stream1 = Stream.of("car", "bus");
        String value = stream1.reduce("test", (str1, str2) -> str1 + str2);
        System.out.println("value " + value);
    }
}
