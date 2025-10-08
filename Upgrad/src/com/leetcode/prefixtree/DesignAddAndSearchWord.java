package com.leetcode.prefixtree;

//Design a data structure that supports adding new words and finding if a string matches any previously added string.
/* Implement the WordDictionary class:
    * WordDictionary() Initializes the object.
    * void addWord(word) Adds word to the data structure, it can be matched later.
    * bool search(word) Returns true if there is any string in the data structure that matches word or false otherwise.
    *  word may contain dots '.' where dots can be matched with any letter.
 */

/*
 * Input
    ["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
  [[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
  * Output
    [null,null,null,null,false,true,true,true]
  * Explanation
    WordDictionary wordDictionary = new WordDictionary();
    wordDictionary.addWord("bad");
    wordDictionary.addWord("dad");
    wordDictionary.addWord("mad");
    wordDictionary.search("pad"); // return False
    wordDictionary.search("bad"); // return True
    wordDictionary.search(".ad"); // return True
    wordDictionary.search("b.."); // return True
 */
public class DesignAddAndSearchWord {

    TrieNodeMap root;
    public DesignAddAndSearchWord(){
            root = new TrieNodeMap();
    }

    public void addWord(String word) {
        TrieNodeMap curr = root;

        for (char ch : word.toCharArray()) {
            if (!curr.child.containsKey(ch)) {
                curr.child.put(ch, new TrieNodeMap());
            }
            curr = curr.child.get(ch);
        }
        curr.isEndOfWord = true;
    }

    public boolean searchInNode(String word, TrieNodeMap curr) {
       // System.out.println("searchInNode word " + word  + " curr " + curr.child.keySet());
        for(int i=0; i< word.length(); i++){
            char ch = word.charAt(i);
            if(!curr.child.containsKey(ch)){
                if(ch == '.'){

                    for(char x: curr.child.keySet()){
                        TrieNodeMap child = curr.child.get(x);
                        System.out.println("curr  x: " + x + " key1 " + curr.child.keySet() );
                        if(searchInNode(word.substring(i+1), child)){
                            return true;
                        }
                    }
                }
                return false;
            }else{
                curr = curr.child.get(ch);
            }

        }
        return curr.isEndOfWord;
    }
    public boolean search(String word) {
        return searchInNode(word, root);
    }

    public static void main(String[] args) {

        DesignAddAndSearchWord trie = new DesignAddAndSearchWord();
//        trie.addWord("bad");
//        trie.addWord("bd");
//        trie.addWord("bbb");
//        trie.addWord("bah");
//        trie.addWord("bat");
//        trie.addWord("aaa");
//        trie.addWord("dad");
//        trie.addWord("mad");
      //      trie.addWord("aaa");
       // System.out.println("Trie " + trie.root);

        trie.addWord("bbt");
        trie.addWord("bcd");
       // trie.addWord("bat");

      //  System.out.println(trie.search("..d"));
        System.out.println(trie.search("b.d"));
       // System.out.println(trie.search("pad"));
       // System.out.println(trie.search(".ad"));
       // System.out.println(trie.search("b.."));
    }

}
