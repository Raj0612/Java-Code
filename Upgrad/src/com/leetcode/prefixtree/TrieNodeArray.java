package com.leetcode.prefixtree;

import java.util.Arrays;

public class TrieNodeArray {
    TrieNodeArray[] child;
    boolean isEndOfWord;

    TrieNodeArray(){
        child = new TrieNodeArray[26];
        this.isEndOfWord = false;
    }

    @Override
    public String toString() {
        return "TrieNode{" +
                "child=" + Arrays.toString(child) +
                ", isEndOfWord=" + isEndOfWord +
                '}';
    }
}
