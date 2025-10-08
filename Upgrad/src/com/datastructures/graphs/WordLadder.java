package com.datastructures.graphs;

import java.util.*;

//A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:
/*
    *) Every adjacent pair of words differs by a single letter.
    *) Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
    * sk == endWord
 */
//Given two words, beginWord and endWord, and a dictionary wordList, return the number of words in the shortest transformation sequence from beginWord to endWord,
// or 0 if no such sequence exists.
/*
Example 1:
Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
Output: 5
Explanation: One shortest transformation sequence is "hit" -> "hot" -> "dot" -> "dog" -> cog", which is 5 words long.

Example 2:
Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
Output: 0
Explanation: The endWord "cog" is not in wordList, therefore there is no valid transformation sequence.
 */
public class WordLadder {

    public static void main(String[] args) {
        input1();
        System.out.println();
        input2();
        System.out.println();
        input3();
    }

    static void input1(){
        String beginWord = "hit";
        String endWord = "cog";

        List<String> list = new ArrayList<>();
        list.add("hot");
        list.add("dot");
        list.add("dog");
        list.add("lot");
        list.add("log");
        list.add("cog");

        System.out.println("input1 ladderLength " + ladderLength(beginWord,endWord, list));
    }

    static void input2(){
        String beginWord = "hit";
        String endWord = "cog";

        List<String> list = new ArrayList<>();
        list.add("hot");
        list.add("dot");
        list.add("dog");
        list.add("lot");
        list.add("log");

        System.out.println("input2 ladderLength " + ladderLength(beginWord,endWord, list));
    }

    static void input3(){
        String beginWord = "hit";
        String endWord = "cog";

        List<String> list = new ArrayList<>();
        list.add("hot");
        list.add("log");
        list.add("dog");
        list.add("lot");
        list.add("dot");
        list.add("cog");

        System.out.println("input3 ladderLength " + ladderLength(beginWord,endWord, list));
    }

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> dictionary = new HashSet<>(wordList);
        System.out.println("ladderLength wordList " + wordList + ": dictionary " + dictionary + " beginWord " + beginWord + " endWord " + endWord);
        HashSet<String> visited = new HashSet<>();
        Queue<NodeInfo3> queue = new LinkedList<>();

        queue.add(new NodeInfo3(beginWord, 0));
        visited.add(beginWord);
        while (!queue.isEmpty()){
            NodeInfo3 currNode = queue.poll();

            if(currNode.word.equals(endWord)){
                return currNode.level + 1;
            }

            StringBuilder str = new StringBuilder(currNode.word);
            for(int i=0; i< str.length(); i++){
                StringBuilder str1 = new StringBuilder(currNode.word);
            //    String str2 = new String(str1);
               // if(str2.equals("log"))
               //     System.out.println("str1 " + str1);
                for(char ch='a'; ch <= 'z'; ch++){
                    str1.setCharAt(i, ch);
                    String neighbour = new String(str1);
                    if(dictionary.contains(neighbour) && !visited.contains(neighbour)){
                        queue.add(new NodeInfo3(neighbour, currNode.level +1));
                        visited.add(neighbour);
                    }
                }
            }
        }

        return 0;
    }
}

class NodeInfo3{

    String word;
    int level;

    public NodeInfo3(String word, int level) {
        this.word = word;
        this.level = level;
    }

    @Override
    public String toString() {
        return "NodeInfo3{word: " + word + " level " + level +" }";
    }
}
