package com.leetcode.zothers;
//You are given a string s consisting of lowercase English letters. A duplicate removal consists of choosing two adjacent and equal letters and removing them.
//We repeatedly make duplicate removals on s until we no longer can.
//Return the final string after all such duplicate removals have been made. It can be proven that the answer is unique.

/*
        Input: s = "abbaca"
        Output: "ca"
        Explanation:
        For example, in "abbaca" we could remove "bb" since the letters are adjacent and equal, and this is the only possible move.
        The result of this move is that the string is "aaca", of which only "aa" is possible, so the final string is "ca".
 */

public class RemoveAllAdjacentDuplicatesInAString {
    public static void main(String[] args) {
        input1();
        input2();
    }

    public static String removeDuplicates(final String S) {
        System.out.println("removeDuplicates " + S);
        StringBuilder sb = new StringBuilder();

        for (final char c : S.toCharArray()) {
            final int n = sb.length();
            if (n > 0 && sb.charAt(n - 1) == c)
                sb.deleteCharAt(n - 1);
            else
                sb.append(c);
        }

        return sb.toString();
    }



    //Brute-Force Time-O(n*n) Space-O(n)
    public static String removeDuplicatesNotOptimized(String s) {
        boolean has_Duplicate = false;
        StringBuilder sb = new StringBuilder(s); //Space - O(n)

       while(true){ // (n/2 times at max)
           for(int i=0; i< sb.length();i++){ // O(n)
               has_Duplicate = false;
                if(s.charAt(i) == sb.charAt(i+1)) {
                    sb.delete(i, i + 2);
                    has_Duplicate = true;
                    break;
                }
           }

           if(!has_Duplicate)
               break;
       }
        return sb.toString();
    }

    static void input1(){
        String str = "abbbaca";
        System.out.println("removeDuplicates " + removeDuplicates(str));
        //System.out.println("removeDuplicatesNotOptimized " + removeDuplicatesNotOptimized(str));
    }

    static void input2(){
        String str = "azxxzy";
        //System.out.println("removeDuplicates " + removeDuplicates(str));
        //System.out.println("removeDuplicatesNotOptimized " + removeDuplicatesNotOptimized(str));
    }
}
