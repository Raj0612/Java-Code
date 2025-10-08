package learn.java8features.functionalinterfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerExample {

    public static void main(String[] args) {
        Consumer<Integer> display = a -> System.out.println(a);
        display.accept(10);

        Consumer<List<Integer>> modify = list ->{
            for (int i = 0; i < list.size(); i++)
                list.set(i, 2 * list.get(i));
        };

        Consumer<List<Integer> >
                dispList = list -> list.stream().forEach(a -> System.out.print(a + " "));

        List<Integer> list = new ArrayList<Integer>();
        list.add(2);
        list.add(1);
        list.add(3);

        modify.accept(list);
        dispList.accept(list);
        System.out.println();
        List<Integer> list1 = new ArrayList<Integer>();
        list1.add(1);
        list1.add(2);
        list1.add(3);

        modify.andThen(dispList).accept(list1);

    }

}
