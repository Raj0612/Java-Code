package learn.java8features.streamapi;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class IntermediateOperationExample {

    public static void main(String[] args) {
        ArrayList<Integer> al = new ArrayList<Integer>();
        al.add(2);
        al.add(6);
        al.add(9);
        al.add(4);
        al.add(20);
        System.out.println("Printing the collection : " + al);
        System.out.println();

        List<Integer> filterList
                = al.stream()
                .filter(i -> i % 2 == 0)
                .collect(Collectors.toList());

        System.out.println(
                "Printing the List after stream operation by filter : " + filterList);

        List<Integer> mapList
                = al.stream()
                .map(i -> i + 2)
                .collect(Collectors.toList());

        System.out.println(
                "Printing the List after stream operation by map : " + mapList);


        List<Integer> sortedList
                = al.stream()
                .sorted(Integer::compareTo)
                .collect(Collectors.toList());

        System.out.println(
                "Printing the List after stream operation by sorted : " + sortedList);
    }
}
