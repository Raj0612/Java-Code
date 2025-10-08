package learn.java8features.streamapi;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamMethodsExample {

    public static void main(String[] args) {

        //map
        List<Integer> number = Arrays.asList(2,3,4,5);
        List square = number.stream().map(x->x*x).collect(Collectors.toList());
        System.out.println("map: " + square);

        //filter
        List<String> names = Arrays.asList("Reflection","Collection","Stream");
        List result = names.stream().filter(s->s.startsWith("S")).collect(Collectors.toList());
        System.out.println("filter: " + result);

        //sorted
        names = Arrays.asList("Reflection","Collection","Stream");
        result = names.stream().sorted().collect(Collectors.toList());
        System.out.println("sorted: " + result);

        //collect
        number = Arrays.asList(2,3,4,5,3);
        Set square1 = number.stream().map(x->x*x).collect(Collectors.toSet());
        System.out.println("collect: " + square1);
        System.out.println("foreach:");
        //foreach
        number = Arrays.asList(2,3,4,5);
        number.stream().map(x->x*x).forEach(y->System.out.println(y));

        //reduce
        number = Arrays.asList(2,3,4,5);
        int even = number.stream().filter(x->x%2==0).reduce(0,(ans,i)-> ans+i);
        System.out.println("reduce: " +even);
    }
}
