package com.leetcode.prefixtree;

public class Trie {
    Trie[] children = new Trie[27]; // 26 English letters and 1 space
    int frequency;
    String word = "";

    void insert(String word, int frequency) {
        Trie node = this;
        for (char ch : word.toCharArray()) {
            int index = ch == ' ' ? 26 : ch - 'a'; // Convert char to index, space represented by 26
            if (node.children[index] == null) {
                node.children[index] = new Trie();
            }
            node = node.children[index];
        }
        node.frequency += frequency; // Update the frequency of the node (word-end)
        node.word = word;
    }

    Trie search(String prefix) {
        Trie node = this;
        for (char ch : prefix.toCharArray()) {
            int index = ch == ' ' ? 26 : ch - 'a';
            if (node.children[index] == null) {
                return null;
            }
            node = node.children[index];
        }
        return node;
    }
}

/*
Operation: AutocompleteSystem(["i love you", "island","ironman", "i love leetcode"], [5,3,2,2])
The system have already tracked down the following sentences and their corresponding times:
"i love you" : 5 times
"island" : 3 times
"ironman" : 2 times
"i love leetcode" : 2 times
Now, the user begins another search:

Operation: input('i')
Output: ["i love you", "island","i love leetcode"]
Explanation:
There are four sentences that have prefix "i". Among them, "ironman" and "i love leetcode" have same hot degree.
 Since ' ' has ASCII code 32 and 'r' has ASCII code 114, "i love leetcode" should be in front of "ironman".
 Also we only need to output top 3 hot sentences, so "ironman" will be ignored.

Operation: input(' ')
Output: ["i love you","i love leetcode"]
Explanation:
There are only two sentences that have prefix "i ".

Operation: input('a')
Output: []
Explanation:
There are no sentences that have prefix "i a".

Operation: input('#')
Output: []
Explanation:
The user finished the input, the sentence "i a" should be saved as a historical sentence in system. And the following input will be counted as a new search.
 */