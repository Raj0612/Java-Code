package com.leetcode.prefixtree;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/*
nput
["AutocompleteSystem", "input", "input", "input", "input"]
[[["i love you", "island", "iroman", "i love leetcode"], [5, 3, 2, 2]], ["i"], [" "], ["a"], ["#"]]
Output
[null, ["i love you", "island", "i love leetcode"], ["i love you", "i love leetcode"], [], []]

Explanation
AutocompleteSystem obj = new AutocompleteSystem(["i love you", "island", "iroman", "i love leetcode"], [5, 3, 2, 2]);
obj.input("i"); // return ["i love you", "island", "i love leetcode"]. There are four sentences that have prefix "i".
 Among them, "ironman" and "i love leetcode" have same hot degree. Since ' ' has ASCII code 32 and 'r' has ASCII code 114, "i love leetcode" should be in front of "ironman".
  Also we only need to output top 3 hot sentences, so "ironman" will be ignored.
obj.input(" "); // return ["i love you", "i love leetcode"]. There are only two sentences that have prefix "i ".
obj.input("a"); // return []. There are no sentences that have prefix "i a".
obj.input("#"); // return []. The user finished the input, the sentence "i a" should be saved as a historical sentence in system.
And the following input will be counted as a new search.
 */

public class AutocompleteSystem {
    private Trie rootTrie = new Trie(); // Trie root
    private StringBuilder currentInput = new StringBuilder();

    public AutocompleteSystem(String[] sentences, int[] times) {
        for (int i = 0; i < sentences.length; i++) {
            rootTrie.insert(sentences[i], times[i]);
        }
    }

    public List<String> input(char inputChar) {
        List<String> autocompleteResult = new ArrayList<>();
        if (inputChar == '#') {
            rootTrie.insert(currentInput.toString(), 1); // Insert the current input into the trie
            currentInput = new StringBuilder(); // Reset builder for next input
            return autocompleteResult; // Autocomplete list is empty for new input
        }
        currentInput.append(inputChar); // Adding new character to current input
        Trie node = rootTrie.search(currentInput.toString());
        if (node == null) {
            return autocompleteResult; // If no node found, return empty list
        }
        PriorityQueue<Trie> minHeap
                = new PriorityQueue<>((a, b) -> a.frequency == b.frequency ? b.word.compareTo(a.word) : a.frequency - b.frequency);
        depthFirstSearch(node, minHeap);
        while (!minHeap.isEmpty()) {
            autocompleteResult.add(0, minHeap.poll().word);
        }
        return autocompleteResult; // Return the list of autocompleted words
    }


    private void depthFirstSearch(Trie node, PriorityQueue<Trie> minHeap) {
        if (node == null || minHeap.size() > 3 && node.frequency < minHeap.peek().frequency) {
            return; // Early return condition to prune the search
        }
        if (node.frequency > 0) {
            minHeap.offer(node); // If it's a word, offer to the min-heap
            if (minHeap.size() > 3) {
                minHeap.poll(); // Keep the size of min-heap no larger than 3
            }
        }
        for (Trie childNode : node.children) {
            depthFirstSearch(childNode, minHeap); // Recursively search children
        }
    }

}
