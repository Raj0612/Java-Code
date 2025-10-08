package learn.java8features.lambdaexpressions.collections;

import java.util.TreeMap;

public class TreeMapSorting {
    public static void main(String[] args) {
        TreeMap<Integer, String> m =
                new TreeMap<Integer, String>((o1, o2) -> (o1 > o2) ? -1 : (o1 < o2) ? 1 : 0);
        m.put(1, "Apple");
        m.put(4, "Mango");
        m.put(5, "Orange");
        m.put(2, "Banana");
        m.put(3, "Grapes");
        System.out.println("Elements of the TreeMap  after sorting are : " + m);
    }
}
