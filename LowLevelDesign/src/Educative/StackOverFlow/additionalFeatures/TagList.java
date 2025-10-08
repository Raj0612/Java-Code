package Educative.StackOverFlow.additionalFeatures;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TagList {
    private static TagList instance;
    private Map<Tag, Integer> tagsCount;

    private TagList() {
        tagsCount = new HashMap<>();
    }

    public static TagList getInstance() {
        if (instance == null) {
            instance = new TagList();
        }
        return instance;
    }

    public boolean addTag(Tag tag) {
        tagsCount.put(tag, tagsCount.getOrDefault(tag, 0) + 1);
        return true;
    }

    public void incrementTagCount(Tag tag) {
        tagsCount.put(tag, tagsCount.getOrDefault(tag, 0) + 1);
    }

    public void decrementTagCount(Tag tag) {
        tagsCount.put(tag, tagsCount.getOrDefault(tag, 0) - 1);
    }

    public List<Tag> getPopularTags(int topN) {
        List<Map.Entry<Tag, Integer>> entries = new ArrayList<>(tagsCount.entrySet());
        entries.sort((a, b) -> b.getValue() - a.getValue());
        List<Tag> result = new ArrayList<>();
        for (int i = 0; i < Math.min(topN, entries.size()); i++) {
            result.add(entries.get(i).getKey());
        }
        return result;
    }
}
