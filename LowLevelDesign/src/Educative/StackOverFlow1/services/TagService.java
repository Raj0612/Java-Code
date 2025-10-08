package Educative.StackOverFlow1.services;

import Educative.StackOverFlow1.features.Tag;

import java.util.*;

public class TagService {
    private final Map<Tag, Integer> tagCounts = new HashMap<>();

    public boolean addTag(Tag tag) {
        tagCounts.put(tag, tagCounts.getOrDefault(tag, 0) + 1);
        return true;
    }

    public void increment(Tag tag) {
        tagCounts.put(tag, tagCounts.getOrDefault(tag, 0) + 1);
    }

    public void decrement(Tag tag) {
        tagCounts.put(tag, Math.max(0, tagCounts.getOrDefault(tag, 1) - 1));
    }

    public List<Tag> getTopTags(int n) {
        List<Map.Entry<Tag, Integer>> list = new ArrayList<>(tagCounts.entrySet());
        list.sort((a, b) -> Integer.compare(b.getValue(), a.getValue()));
        List<Tag> out = new ArrayList<>();
        for (int i = 0; i < Math.min(n, list.size()); i++)
            out.add(list.get(i).getKey());
        return out;
    }
}
