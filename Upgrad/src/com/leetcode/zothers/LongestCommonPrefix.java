package com.leetcode.zothers;
//Write a function to find the longest common prefix string amongst an array of strings.
//If there is no common prefix, return an empty string "".

/*
Input: strs = ["flower","flow","flight"]
Output: "fl"
 */
public class LongestCommonPrefix {

    public static void main(String[] args) {
        input1();
        System.out.println();
        //input2();
        System.out.println();
      //  input3();
        System.out.println();
       // input4();
        System.out.println();
      // input5();
    }

    //Time Complexity :  O ( m * N).  where m is the length of the prefix and n is the number of strings in the input array.
    public static String longestCommonPrefix(String[] arr) {
        int n = arr.length;
        String result = arr[0];
        System.out.println("longestCommonPrefix result " + result);
        for(int i = 1; i < n; i++){
            System.out.println("longestCommonPrefix arr["+i+"] " +arr[i] + " result " + result);
            System.out.println("index " + arr[i].indexOf(result) );
            while(arr[i].indexOf(result) != 0){

                result = result.substring(0, result.length()-1);
                System.out.println("longestCommonPrefix arr["+i+"] " +arr[i] + " result1 " + result +  " index " + arr[i].indexOf(result));
                if(result.isEmpty()){
                    return "-1";
                }
            }
        }
        System.out.println();
        return result;
    }

    public static String longestCommonPrefix1(String[] strs) {
        if (strs.length == 0)
            return "";

        for (int i = 0; i < strs[0].length(); ++i)
            for (int j = 1; j < strs.length; ++j)
                if (i == strs[j].length() || strs[j].charAt(i) != strs[0].charAt(i))
                    return strs[0].substring(0, i);

        return strs[0];
    }

    //Time - O(m * n)
    public static String longestCommonPrefixUpgrad(String[] arr) {
        StringBuilder lcp = new StringBuilder("");
        String word1 = arr[0];
       // System.out.println("longestCommonPrefixUpgrad word1 " + word1);
        for(int i =0; i <word1.length(); i++){
            char ch = word1.charAt(i);

            for(int j =1 ; j<arr.length; j++){
            //    System.out.println("longestCommonPrefixUpgrad arr["+j+"] " + arr[j] + " i: " + i + " ch: " + ch + " j: " + j);
                if(i >=arr[j].length() || ch != arr[j].charAt(i)){
                    String str = new String(lcp);
                    //System.out.println("longestCommonPrefixUpgrad str " + str);
                    return str;
                }
            }
            lcp.append(ch);
        }
        return new String(lcp);
    }
    static void input1(){
        String[] strs = {"flower", "flow", "flight"};
       // System.out.println("input1 longestCommonPrefix " + longestCommonPrefix(strs));
        //System.out.println("input1 longestCommonPrefix1 " + longestCommonPrefix1(strs));
        System.out.println("input1 longestCommonPrefixUpgrad " + longestCommonPrefixUpgrad(strs));
    }
    static void input2(){
        String[] strs = {"geeksforgeeks", "geeks", "geek", "geezer"};
        System.out.println("input2 longestCommonPrefix " + longestCommonPrefix(strs));
    }
    static void input3(){
        String[] strs = {"geeks", "geeksforgeeks", "geek", "geezer"};
        //System.out.println("input2 longestCommonPrefix " + longestCommonPrefix(strs));
        System.out.println("input2 longestCommonPrefixUpgrad " + longestCommonPrefixUpgrad(strs));
    }
    static void input4(){
        String[] strs = {"geeks", "abc", "geek", "geezer"};
        //System.out.println("input2 longestCommonPrefix " + longestCommonPrefix(strs));
        System.out.println("input2 longestCommonPrefixUpgrad " + longestCommonPrefixUpgrad(strs));
    }

    static void input5(){
        String[] strs = {"flawer", "flow", "abc"};
      //  System.out.println("input5 longestCommonPrefix " + longestCommonPrefix(strs));
      //  System.out.println("input5 longestCommonPrefix1 " + longestCommonPrefix1(strs));
        System.out.println("input5 longestCommonPrefixUpgrad " + longestCommonPrefixUpgrad(strs));

    }

}
