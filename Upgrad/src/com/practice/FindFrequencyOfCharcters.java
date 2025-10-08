package com.practice;

import java.util.HashMap;
import java.util.Map;

public class FindFrequencyOfCharcters {

    public static void main(String args[]) {
        int arr[] = {10, 20, 20, 10, 10, 20, 5, 20};
        int n = arr.length;
        countFreq(arr, n);
    }

    static void countFreq(int arr[], int n) {
        Map<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < n; i++)  {
            if (mp.containsKey(arr[i])) {
                mp.put(arr[i], mp.get(arr[i]) + 1);
            }
            else  {
                mp.put(arr[i], 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : mp.entrySet())  {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
