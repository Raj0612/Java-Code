package com.test.collections;

import java.util.HashMap;

public class MapElement {

    public static void main(String[] args) {

        HashMap<String, Integer> map = new HashMap<>();
        map.put("A", 1);
        System.out.println(map.get("B"));
        System.out.println(!map.get("B").equals(map.get("B")));
    }
}
