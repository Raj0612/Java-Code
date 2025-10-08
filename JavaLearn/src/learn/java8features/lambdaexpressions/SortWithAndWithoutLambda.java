package learn.java8features.lambdaexpressions;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortWithAndWithoutLambda {
    public static void main(String[] args){


        List<Integer> list = Arrays.asList( 234, 780, 451, 639, 456, 98, 75, 43);
        List<Integer> list1 = Arrays.asList( 234, 780, 451, 639, 456, 98, 75, 43);
        withoutLambda(list);
        withLambda(list);

    }

    static void withoutLambda(List<Integer> list){
        System.out.println("Before Sorting");
        for (int i : list)
            System.out.print(i + " ");
        System.out.println();

        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer a1, Integer a2)  {
                return a1 % 10 > a2 % 10 ? 1 : -1;
            }
        });
        System.out.println("After Sorting");
        for (int i : list)
            System.out.print(i + " ");

        System.out.println();
    }

    static void withLambda(List<Integer> list){
        System.out.println("Before Sorting");
        for (int i : list)
            System.out.print(i + " ");
        System.out.println();

        Collections.sort(list, (a1,a2)->{
            return a1%10 > a2%10? 1 :-1;
        });

        System.out.println("After Sorting");
        for (int i : list)
            System.out.print(i + " ");

        System.out.println();
    }
}
