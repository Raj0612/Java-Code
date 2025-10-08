package com.leetcode.prefixtree;

public class ImplementTrieByMap {

    TrieNodeMap root;

    public ImplementTrieByMap() {
        root = new TrieNodeMap();
    }

    public void insert(String word) {
        TrieNodeMap curr = root;

        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);
            curr = curr.child.computeIfAbsent(ch, k -> new TrieNodeMap());
        }
        curr.isEndOfWord = true;
    }

    public boolean search(String word) {
        TrieNodeMap curr = root;

        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);

            if(curr.child.get(ch) == null){
                return false;
            }
            curr = curr.child.get(ch);
        }
        return curr.isEndOfWord;
    }

    public boolean startsWith(String prefix) {
        TrieNodeMap curr = root;

        for(int i=0; i<prefix.length(); i++){
            char ch = prefix.charAt(i); // ch = 'a' --> 'm'

            if(curr.child.get(ch) == null){
                return false;
            }
            curr = curr.child.get(ch);
        }

        return true;
    }

    public static void main(String[] args) {
        ImplementTrieByMap trie = new ImplementTrieByMap();
        trie.insert("apple");
        trie.insert("app");
        trie.insert("cat");
        trie.insert("car");
        System.out.println("After insert " + trie.root);
    }
}