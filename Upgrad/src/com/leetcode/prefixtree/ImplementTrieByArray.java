package com.leetcode.prefixtree;

//A trie (pronounced as "try") or prefix tree is a tree data structure used to efficiently store and retrieve keys in a dataset of strings.
// There are various applications of this data structure, such as autocomplete and spellchecker.

/*Implement the Trie class:
    * Trie() Initializes the trie object.
    * void insert(String word) Inserts the string word into the trie.
    * boolean search(String word) Returns true if the string word is in the trie (i.e., was inserted before), and false otherwise.
    * boolean startsWith(String prefix) Returns true if there is a previously inserted string word that has the prefix prefix, and false otherwise. */
public class ImplementTrieByArray {
    TrieNodeArray root;

    public ImplementTrieByArray() {
        root = new TrieNodeArray();
        System.out.println("ImplementTrie root " + root);
    }

    public void insert(String word) {
        TrieNodeArray curr = root;

        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);
            int index = ch - 'a';  // 0 --> 12

            if(curr.child[index] == null){
                curr.child[index] = new TrieNodeArray();
            }
            curr = curr.child[index];
        }
        curr.isEndOfWord = true;

    }
    public boolean search(String word) {
        TrieNodeArray curr = root;

        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i); // ch = 'a' --> 'm'
            int index = ch - 'a';  // 0 --> 12

            if(curr.child[index] == null){
                return false;
            }
            curr = curr.child[index];
        }
        return curr.isEndOfWord;
    }

    public boolean startsWith(String prefix) {
        TrieNodeArray curr = root;

        for(int i=0; i<prefix.length(); i++){
            char ch = prefix.charAt(i); // ch = 'a' --> 'm'
            int index = ch - 'a';  // 0 --> 12

            if(curr.child[index] == null){
                return false;
            }
            curr = curr.child[index];
        }

        return true;
    }

    public static void main(String[] args) {
        ImplementTrieByArray trie = new ImplementTrieByArray();
        trie.insert("apple");
       // trie.insert("app");
        trie.insert("cat");
      //  trie.insert("car");
        System.out.println("After insert " + trie.root);
    }
}


