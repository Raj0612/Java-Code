package com.leetcode.binaryheap;
/*
Given an array of strings words and an integer k, return the k most frequent strings.
Return the answer sorted by the frequency from highest to lowest. Sort the words with the same frequency by their lexicographical order.

Example 1:
Input: words = ["i","love","leetcode","i","love","coding"], k = 2
Output: ["i","love"]
Explanation: "i" and "love" are the two most frequent words.
Note that "i" comes before "love" due to a lower alphabetical order.

Example 2:
Input: words = ["the","day","is","sunny","the","the","the","sunny","is","is"], k = 4
Output: ["the","is","sunny","day"]
Explanation: "the", "is", "sunny" and "day" are the four most frequent words, with the number of occurrence being 4, 3, 2 and 1 respectively.
 */

import java.util.HashMap;
import java.util.*;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentWords {
    public static void main(String[] args) {
        input1();
       // input2();
    }

    static void input1() {
        String[] words = {"i","love", "a","leetcode","i","leetcode", "a","coding"};
        int k = 2;
        System.out.println("input1 words: " + Arrays.toString(words) + " k " + k);
        System.out.println("input1: topKFrequent " + topKFrequent(words, k));
        System.out.println("input1: topKFrequent1 " + topKFrequent1(words, k));
    }

    static void input2() {
        String[] words = {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
        int k = 4;
        System.out.println("input2 words: " + Arrays.toString(words) + " k " + k);
        System.out.println("input2: topKFrequent " + topKFrequent(words, k));
        System.out.println("input2: topKFrequent1 " + topKFrequent1(words, k));
    }


    public static List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> wordCount = new LinkedHashMap<>();
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
        System.out.println("topKFrequent wordCount: " + wordCount);
        PriorityQueue<String> heap = new PriorityQueue<>((word1, word2) -> {
            int frequencyDifference = wordCount.get(word1) - wordCount.get(word2);
            if (frequencyDifference == 0) {
                return word2.compareTo(word1);
            }
            return frequencyDifference;
        });
        for (String word : wordCount.keySet()) {
            heap.offer(word);
            // If heap size exceeds k, remove the least frequent/current smallest element
            if (heap.size() > k) {
                heap.poll();
            }
        }
        System.out.println("topKFrequent heap: " + heap);
        LinkedList<String> topKWords = new LinkedList<>();
        while (!heap.isEmpty()) {
            topKWords.addFirst(heap.poll());
        }
        return topKWords;
    }

    public static List<String> topKFrequent1(String[] words, int k) {
        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
        System.out.println("topKFrequent wordCount: " + wordCount);
        PriorityQueue<StringInfo> heap = new PriorityQueue<>((word1, word2) -> {
            int frequencyDifference = word2.value - word1.value;
            if (frequencyDifference == 0) {
                return word1.key.compareTo(word2.key);
            }
            return frequencyDifference;
        });
        for (Map.Entry<String, Integer> en : wordCount.entrySet()) {
            String key = en.getKey();
            int value = en.getValue();

            StringInfo info = new StringInfo(key, value);
            heap.add(info);
        }
        List<String> result = new ArrayList<>();
        System.out.println("topKFrequent1 heap " + heap);
        for(int j =0 ; j<k; j++){ //O(k)
            StringInfo info = heap.poll();
            result.add(info.key);
        }

        return result;
    }
}

class StringInfo{
    String key;
    int value;

    @Override
    public String toString() {
        return "StringInfo{" +
                "key=" + key +
                ", value=" + value +
                '}';
    }

    public StringInfo(String key, int value){
        this.key = key;
        this.value = value;
    }
}
